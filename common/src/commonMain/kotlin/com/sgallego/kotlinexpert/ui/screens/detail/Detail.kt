package com.sgallego.kotlinexpert.ui.screens.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.sgallego.kotlinexpert.ui.screens.home.Home
import com.sgallego.kotlinexpert.ui.viewmodels.DetailViewModel
import com.sgallego.kotlinexpert.ui.viewmodels.HomeViewModel


data class DetailScreen(val noteId: Long): Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Detail(
            vm = DetailViewModel(rememberCoroutineScope(), noteId),
            onClose = { navigator.pop() },
            id = noteId
        )
    }

}

@Composable
expect fun Detail(vm: DetailViewModel, id: Long, onClose: () -> Unit)