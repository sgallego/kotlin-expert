package com.sgallego.kotlinexpert

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun App(): Unit = with(AppState) {

    val state by state.collectAsState()

    LaunchedEffect(true) {
        loadNotes(this)
    }


    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
                if (state.loading) {
                    CircularProgressIndicator()
                }
                state.notes.let {
                    NotesList(it)
                }
            }

    }

}

@Composable
private fun NotesList(notes: List<Note>){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(notes) { note ->
            Card(
                modifier = Modifier.padding(8.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.weight(1f)
                        )
                        if(note.type == Note.Type.AUDIO) {
                            Icon(
                                imageVector = Icons.Default.Mic, contentDescription = "Icon"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(note.description)
                }
            }
        }
    }
}