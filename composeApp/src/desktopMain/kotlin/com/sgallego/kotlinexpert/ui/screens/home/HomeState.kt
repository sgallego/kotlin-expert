package com.sgallego.kotlinexpert.ui.screens.home
import com.sgallego.kotlinexpert.data.Note
import com.sgallego.kotlinexpert.data.getNotes
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object HomeState{
    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            _state.emit(UiState(loading = true))
            getNotes().collect{
                _state.emit(UiState(notes = it))
            }
        }
    }

    data class UiState(
        val notes: List<Note> = listOf(), val loading: Boolean = false
    )
}