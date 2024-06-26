package com.sgallego.kotlinexpert.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.sgallego.kotlinexpert.data.Note
import com.sgallego.kotlinexpert.data.remote.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DetailViewModel(private val noteId: Long): ScreenModel{

    var state by mutableStateOf(UiState())
        private set

    init {
        if(noteId != Note.NEW_NOTE){
            loadNote()
        }
    }

    private fun loadNote(){
        screenModelScope.launch {
            state = UiState(loading = true)
            state = UiState(note = NotesRepository.getById(noteId))
        }
    }

    fun save(){
        screenModelScope.launch {
            val note = state.note
            if (note.id == Note.NEW_NOTE) {
                NotesRepository.save(note)
            } else {
                NotesRepository.update(note)
            }
            state = state.copy(saved = true)
        }
    }

    fun update(note: Note){
        state = state.copy(note = note)
    }

    fun delete(){
        screenModelScope.launch {
            NotesRepository.delete(state.note)
            state = state.copy(saved = true)
        }
    }

    data class UiState(
        val note: Note = Note("", "", Note.Type.TEXT),
        val loading: Boolean = false,
        val saved: Boolean = false
    )

}