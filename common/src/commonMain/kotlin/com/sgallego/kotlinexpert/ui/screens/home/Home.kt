package com.sgallego.kotlinexpert.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sgallego.kotlinexpert.data.Note
import com.sgallego.kotlinexpert.ui.viewmodels.HomeViewModel

@Composable
fun Home(vm: HomeViewModel, onNoteClick: (noteId: Long) -> Unit){

    MaterialTheme {
        Scaffold(
            topBar = { TopBar(vm::onFilterClick) },
            floatingActionButton = { FloatingActionButton(onClick = { onNoteClick(Note.NEW_NOTE) } ){
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
            } }
        ) { padding ->
            Box(
                modifier = Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) {
                if (vm.state.loading) {
                    CircularProgressIndicator()
                }
                vm.state.filteredNotes?.let { notes ->
                    NotesList(
                        notes = notes,
                        onNoteClick = {onNoteClick(it.id) }
                    )
                }
            }
        }


    }

}