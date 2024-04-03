package ui.screens.home

import androidx.compose.runtime.Composable
import com.sgallego.kotlinexpert.ui.screens.home.HomeViewModel

@Composable
fun Home(vm: HomeViewModel, onNoteClick: (noteId: Long) -> Unit){
    NotesList(vm.state.filteredNotes ?: emptyList()){ note ->
        onNoteClick(note.id)
    }
}