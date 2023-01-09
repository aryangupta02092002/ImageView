package com.aryan.coilimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.aryan.coilimage.ui.theme.CoilImageTheme
import com.aryan.coilimage.util.CoilImageLibrary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val url = "https://vignette.wikia.nocookie.net/joke-battles/images/4/40/18360-doge-doge-simple.jpg/revision/latest?cb=20151209161638"
        super.onCreate(savedInstanceState)
        setContent {
            CoilImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CoilImageLibrary().imageLoading(url, true, true)
                }
            }
        }
    }
}