package com.sgallego.kotlinexpert.ui

import androidx.compose.runtime.*
import com.sgallego.kotlinexpert.ui.screens.detail.Detail
import com.sgallego.kotlinexpert.ui.screens.home.Home

sealed interface Route{
    data object Home: Route
    data class Detail(val id: Long): Route
}


@Composable
fun App(){

    var route: Route by remember { mutableStateOf<Route>(Route.Home) }

    route.let {
        when (it) {
            Route.Home -> Home(onCreateClick = { route = Route.Detail(-1) })
            is Route.Detail -> Detail(it.id){ route = Route.Home}
        }
    }
}




