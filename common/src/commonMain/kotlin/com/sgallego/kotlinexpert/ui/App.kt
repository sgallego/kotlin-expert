package com.sgallego.kotlinexpert.ui

import androidx.compose.runtime.*
import com.sgallego.kotlinexpert.ui.screens.detail.Detail
import com.sgallego.kotlinexpert.ui.viewmodels.DetailViewModel
import com.sgallego.kotlinexpert.ui.screens.home.Home
import com.sgallego.kotlinexpert.ui.viewmodels.HomeViewModel


@Composable
fun App() {

    var route: Route by remember { mutableStateOf<Route>(Route.Home) }
    val scope = rememberCoroutineScope()

    route.let {
        when (it) {
            Route.Home -> Home(
                vm = HomeViewModel(scope),
                onNoteClick = {noteId -> route = Route.Detail(noteId) }
            )

            is Route.Detail -> Detail(
                vm = DetailViewModel(scope, it.id),
                id = it.id) { route = Route.Home }
        }
    }
}




