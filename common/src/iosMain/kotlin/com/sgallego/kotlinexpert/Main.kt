package com.sgallego.kotlinexpert

import androidx.compose.ui.window.ComposeUIViewController
import com.sgallego.kotlinexpert.ui.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController{
    return ComposeUIViewController {
        App()
    }
}