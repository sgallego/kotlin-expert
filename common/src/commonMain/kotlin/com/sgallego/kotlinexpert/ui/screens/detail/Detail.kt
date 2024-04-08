package com.sgallego.kotlinexpert.ui.screens.detail

import androidx.compose.runtime.Composable
import com.sgallego.kotlinexpert.ui.viewmodels.DetailViewModel

@Composable
expect fun Detail(vm: DetailViewModel, id: Long, onClose: () -> Unit)