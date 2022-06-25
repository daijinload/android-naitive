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
 * FragmentをComposeで作成するサンプル
 *
 * このサンプルでは、Compose Navigationによる遷移（3page to 4page）と、
 * nav_graph.xmlによる遷移(4page to 1page)を行っています。
 *
 * ４ページ目で戻るボタンを押下した場合、３ページには行かず、2ページに移動してしまいます。
 * （戻るボタンがFragment単位で遷移させるため。）
 *
 * この現象から、移行が完全に終わるまでは、１つのFragmentに
 * １つのComposeとして遷移はnav_graph.xmlで指定していく方針が良さそう。
 */
class MyComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            // 画面のライフサイクルを下記で決める（細かい破棄条件を指定できる）
            // 下記は、ビューのLifecycleOwnerが破棄されたときに、Compositionを破棄します。
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                DaijinComposeTheme {
                    // In Compose world
                    // findNavControllerを直接下に渡さずに、ラムダ式で渡すことにより、
                    // プレビューやテストがしやすくなる（findNavControllerを作るのは大変そう。。。）
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
            NavHost(navController = navController, startDestination = "3page") {
                composable("3page") {
                    MainScreen {
                        // こちらの遷移方法は全てがComposeの場合の推奨の書き方だが、
                        // Fragment管理下ではないので、戻るボタンでスキップされてしまう。
                        // 4ページ目で戻るボタンを押すと、３ページがスキップされるから注意。
                        navController.navigate("4page")
                    }
                }
                composable("4page") {
                    SecondScreen{
                        // こちらの遷移方法だと、Fragment管理下なので、ちゃんと移動できる。
                        onNavigate(R.id.action_MyComposeFragment_to_FirstFragment)
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(onClick: () -> Unit) {
    Column() {
        Text("3page Compose Screen!!")
        Button(onClick = onClick) {
            Text("Next")
        }
    }
}

@Composable
fun SecondScreen(onClick: () -> Unit) {
    Column() {
        Text("4page Compose Screen!!")
        Button(onClick = onClick) {
            Text("Go To First!!")
        }
    }
}
