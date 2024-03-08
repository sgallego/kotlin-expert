package com.sgallego.kotlinexpert.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.sgallego.kotlinexpert.data.Filter
import com.sgallego.kotlinexpert.data.Note
import com.sgallego.kotlinexpert.data.remote.NotesRepository
import kotlinx.coroutines.*

class HomeViewModel(private val scope: CoroutineScope){

    var state by mutableStateOf(UiState())
        private set

    init {
        loadNotes(scope)
    }

    private fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            state = UiState(loading = true)
            val response = NotesRepository.getAll()
            state = UiState(notes = response)
        }
    }

    fun onFilterClick(filter: Filter){
        state = state.copy(filter = filter)
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false,
        val filter: Filter = Filter.All,
    ){

        val filteredNotes: List<Note>?
            get() = when(filter){
            Filter.All -> notes
            is Filter.ByType -> notes?.filter { it.type == filter.type }
        }
    }
}