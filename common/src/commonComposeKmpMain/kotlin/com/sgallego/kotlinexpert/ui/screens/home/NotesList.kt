package com.sgallego.kotlinexpert.ui.screens.home


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sgallego.kotlinexpert.data.Note

@Composable
fun NotesList(notes: List<Note>, onNoteClick: (Note)->Unit){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(notes) { note ->
            Card(
                modifier = Modifier.padding(8.dp)
                    .fillMaxWidth(0.8f)
                    .clickable {
                        onNoteClick(note)
                    }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.titleLarge,
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