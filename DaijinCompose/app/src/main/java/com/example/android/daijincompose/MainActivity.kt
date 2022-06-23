package com.example.android.daijincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android.daijincompose.ui.theme.DaijinComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaijinComposeTheme {
                MyApp()
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    DaijinComposeTheme {
        MyApp()
    }
}

@Composable
fun MyApp() {
    DaijinComposeTheme {
        val navController = rememberNavController()
        Scaffold() {
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    // 引数としてnavControllerを渡す
                    MainScreen {
                        navController.navigate("second")
                    }
                }
                composable("second") {
                    SecondScreen()
                }
                activity(id = R.id.nav_oss_licenses) {
                    activityClass = OssLicensesMenuActivity::class
                }
            }
        }
    }
}

@Composable
fun MainScreen(toSecond: () -> Unit) {
    Column() {
        Text("Hello")
        Button(onClick = toSecond) {
            Text("Next")
        }
    }
}

@Composable
fun SecondScreen() {
    Text("2nd Screen!!")
}
