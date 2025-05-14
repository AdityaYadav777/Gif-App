package com.aditya.gif_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.aditya.gif_app.Screens.Home
import com.aditya.gif_app.ViewModels.HomeViewModel
import com.aditya.gif_app.ui.theme.GIFAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GIFAppTheme {
                   val viewModel: HomeViewModel by viewModels()
                   Home(viewModel)
            }
        }
    }
}

