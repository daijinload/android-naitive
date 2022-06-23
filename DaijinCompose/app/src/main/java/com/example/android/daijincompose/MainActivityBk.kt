package com.example.android.daijincompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.daijincompose.ui.theme.DaijinComposeTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

class MainActivityBk : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

//package com.example.android.daijincompose
//
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.animation.core.Spring
//import androidx.compose.animation.core.animateDpAsState
//import androidx.compose.animation.core.spring
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.android.daijincompose.ui.theme.DaijinComposeTheme
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            DaijinComposeTheme {
//                MyApp()
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true, widthDp = 320)
//@Composable
//fun DefaultPreview() {
//    DaijinComposeTheme {
//        MyApp()
//    }
//}
//
//
////@Composable
////fun MyApp(names: List<String> = listOf("World", "Compose", "Compose222")) {
////    Column(modifier = Modifier.padding(vertical = 4.dp)) {
////        for (name in names) {
////            Greeting(name = name)
////        }
////    }
////}
//@Composable
//fun MyApp(names: List<String> = List(1000) { "$it" }) {
//    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
//        items(items = names) { name ->
//            Greeting(name = name)
//        }
//    }
//}
//
//
//@Composable
//private fun Greeting(name: String) {
//
//    var expanded by remember { mutableStateOf(false) }
//
//    val extraPadding by animateDpAsState(
//        if (expanded) 48.dp else 0.dp,
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioMediumBouncy,
//            stiffness = Spring.StiffnessLow
//        )
//    )
//    Surface(
//        color = MaterialTheme.colors.primary,
//        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(modifier = Modifier
//                .weight(1f)
//                .padding(bottom = extraPadding.coerceAtLeast(0.dp))
//            ) {
//                Text(text = "Hello, ")
//                Text(text = name)
//            }
//            OutlinedButton(
//                onClick = { expanded = !expanded }
//            ) {
//                Text(if (expanded) "Show less" else "Show more")
//            }
//
//        }
//    }
//}
//
//@Composable
//fun OnboardingScreen() {
//    // TODO: This state should be hoisted
//    var shouldShowOnboarding by remember { mutableStateOf(true) }
//
//    Surface {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Welcome to the Basics Codelab!")
//            Button(
//                modifier = Modifier.padding(vertical = 24.dp),
//                onClick = { shouldShowOnboarding = false }
//            ) {
//                Text("Continue")
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true, widthDp = 320, heightDp = 320)
//@Composable
//fun OnboardingPreview() {
//    DaijinComposeTheme {
//        OnboardingScreen()
//    }
//}
//
////@Composable
////private fun Greeting(name: String) {
////    Surface(
////        color = MaterialTheme.colors.primary,
////        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
////    ) {
////        Row(modifier = Modifier.padding(24.dp)) {
////            Column(modifier = Modifier.weight(1f)) {
////                Text(text = "Hello, ")
////                Text(text = name)
////            }
////            OutlinedButton(
////                onClick = { Log.d("MyApp","on click!!") }
////            ) {
////                Text("Show more")
////            }
////        }
////    }
////}
//
//
////@Composable
////private fun Greeting(name: String) {
////    Surface(
////        color = MaterialTheme.colors.primary,
////        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
////    ) {
////        Column(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
////            Text(text = "Hello, ")
////            Text(text = name)
////        }
////    }
////}
//
////@Composable
////private fun MyApp() {
////    Surface(
////        // modifier = Modifier.fillMaxSize(),
////        color = MaterialTheme.colors.background
////    ) {
////        Greeting("Android")
////    }
////}
////@Composable
////fun MyApp(names: List<String> = listOf("World", "Compose")) {
////    Column {
////        for (name in names) {
////            Greeting(name = name)
////        }
////    }
////}
////
////@Composable
////fun Greeting(name: String) {
////    Surface(color = MaterialTheme.colors.primary) {
////        Column(modifier = Modifier.padding(24.dp)) {
////            Text(text = "Hello,")
////            Text(text = name)
////        }
////    }
////}
