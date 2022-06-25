package com.example.android.basictocompose

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.findNavController
import com.example.android.basictocompose.ui.theme.DaijinComposeTheme


/**
 * ComposeをFragmentとして扱うサンプル
 * このComposeではページ遷移をしているが、戻るボタンはFragment単位で動くので、
 * SecondページからFirstページには行かず、Fragment側の画面に移動する。
 *
 * この現象から、移行が完全に終わるまでは、１つのFragmentに
 * １つのComposeとして遷移はFragmentで指定する必要がありそう。
 */
class MyComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                DaijinComposeTheme {
                    // In Compose world
                    //Text("Hello Compose!")
                    MyApp{dest -> findNavController().navigate(dest)}
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    DaijinComposeTheme {
        MyApp{}
    }
}

@Composable
fun MyApp(onNavigate: (Int) -> Unit) {
    DaijinComposeTheme {
        val navController = rememberNavController()
        Scaffold() {
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    MainScreen {
                        // こちらの遷移方法は全てがComposeの場合の推奨の書き方だが、
                        // Fragment管理下ではないので、戻るボタンでスキップされてしまう。
                        // 試しにsecond画面まで行って、戻るボタンで戻ってみると良い。
                        navController.navigate("second")
                    }
                }
                composable("second") {
                    SecondScreen{
                        // こちらの遷移方法だと、Fragment管理下なので、ちゃんと移動できる。
                        onNavigate(R.id.action_SecondFragment_to_FirstFragment)
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(toSecond: () -> Unit) {
    Column() {
        Text("Compose 1st Screen!!")
        Button(onClick = toSecond) {
            Text("Next")
        }
    }
}

@Composable
fun SecondScreen(toFirstFragment: () -> Unit) {
    Column() {
        Text("Compose 2nd Screen!!")
        Button(onClick = toFirstFragment) {
            Text("Next")
        }
    }
}
