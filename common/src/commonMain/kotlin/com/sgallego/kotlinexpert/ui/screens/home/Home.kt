package com.sgallego.kotlinexpert.ui.screens.home

import androidx.compose.runtime.Composable
import com.sgallego.kotlinexpert.ui.viewmodels.HomeViewModel

@Composable
expect fun Home(vm: HomeViewModel, onNoteClick: (noteId: Long) -> Unit)