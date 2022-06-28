package com.example.android.basictocompose

import android.graphics.Bitmap
import android.os.Environment
import android.util.Log
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.FileOutputStream


@RunWith(AndroidJUnit4::class)
class MyComposeFragmentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun helloWorldScreenshot() {
        composeTestRule.setContent {
            MyApp{}
        }

        val bitmap = composeTestRule.onRoot().captureToImage().asAndroidBitmap()
        saveScreenshot("hello-world", bitmap)
    }
}

// TODO スクリーンショットは保存されるが、エミュレータの中に保存されるため、どうにかして取り出したい。。。
// [View] > [Tool Windows] > [Device File Explorer] で中身は見れる。パスは下記
// /data/data/com.example.android.basictocompose/files/hello-world.png
// /sdcard/Download/dog-best-friend-1.png
private fun saveScreenshot(filename: String, bmp: Bitmap) {
    val path = Environment.getExternalStorageDirectory().path
    val myPngPath = "$path/Download/dog-best-friend-1.png"
    val canonicalPath = InstrumentationRegistry.getInstrumentation().targetContext.filesDir.canonicalPath
    Log.d("TestScreenShot", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa: $canonicalPath/$filename.png");
    Log.d("TestScreenShot", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2: $myPngPath");
//    FileOutputStream("$path/$filename.png").use { out ->
    FileOutputStream(myPngPath).use { out ->
        bmp.compress(Bitmap.CompressFormat.PNG, 100, out)
    }
    println("Saved screenshot to $path/$filename.png")
}
