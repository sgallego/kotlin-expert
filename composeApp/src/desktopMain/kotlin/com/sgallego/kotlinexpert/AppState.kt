package com.sgallego.kotlinexpert
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object AppState{
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