package com.sgallego.kotlinexpert.ui

import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import com.sgallego.kotlinexpert.ui.screens.home.HomeScreen


@Composable
fun App() {
    Navigator(HomeScreen)
}




