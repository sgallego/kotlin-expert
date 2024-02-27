package com.sgallego.kotlinexpert

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class Note(
    val title: String,
    val description: String,
    val type: Type
) {

    enum class Type {
        TEXT, AUDIO
    }

}


suspend fun getNotes(): Flow<List<Note>> = flow {
    delay(2000)
    val notes = (0..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
    }
    emit(notes)

}