package com.sgallego.kotlinexpert

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sgallego.kotlinexpert.ui.App

fun main() {
    application {
        Window(onCloseRequest = ::exitApplication, title = getAppTitle()) {
            App()
        }
    }
}


@Preview
@Composable
fun AppDesktopPreview() {
    App()
}