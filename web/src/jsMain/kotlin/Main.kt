import androidx.compose.runtime.*
import com.sgallego.kotlinexpert.data.Note
import com.sgallego.kotlinexpert.ui.screens.home.HomeViewModel
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import ui.theme.AppStyleSheet

fun main() {

    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        val scope = rememberCoroutineScope()
        val homeViewModel = remember { HomeViewModel(scope) }

        NotesList(homeViewModel.state.filteredNotes ?: emptyList()){ note ->
            console.log("Note clicked: $note")

        }

    }
}

@Composable
fun NotesList(notes: List<Note>, onNoteClick: (Note) -> Unit){
    Div(attrs = {
        classes(AppStyleSheet.notesList)
    }){
        notes.forEach {  note ->
            NoteCard(note, onNoteClick)
        }
    }
}

@Composable
fun NoteCard(note: Note, onNoteClick: (Note) -> Unit){
    Div(
        attrs = {
            onClick { onNoteClick(note) }
            classes(AppStyleSheet.noteCard)
        }
    ) {
        Div(
            attrs = {
                classes(AppStyleSheet.noteCardHeader)
            }
        ) {
            H3(
                attrs = {
                    classes(AppStyleSheet.noteCardTitle)
                }
            ) { Text(note.title) }
            if(note.type == Note.Type.AUDIO){
                Span { Text("🎤") }
            }
        }

        Div {
            Text(note.description)
        }
    }
}