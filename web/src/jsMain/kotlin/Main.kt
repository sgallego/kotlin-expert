import androidx.compose.runtime.*
import com.sgallego.kotlinexpert.data.Note
import com.sgallego.kotlinexpert.getAppTitle
import com.sgallego.kotlinexpert.ui.screens.home.HomeViewModel
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {

    renderComposable(rootElementId = "root") {

        val scope = rememberCoroutineScope()
        val homeViewModel = remember { HomeViewModel(scope) }

        NotesList(homeViewModel.state.filteredNotes ?: emptyList()){ note ->
            console.log("Note clicked: $note")

        }

    }
}

@Composable
fun NotesList(notes: List<Note>, onNoteClick: (Note) -> Unit){
    Div{
        notes.forEach {  note ->
            NoteCard(note, onNoteClick)
        }
    }
}

@Composable
fun NoteCard(note: Note, onNoteClick: (Note) -> Unit){
    Div(
        attrs = {
            onClick {
                onNoteClick(note)
            }
        }
    ) {
        H3 { Text(note.title) }
        if(note.type == Note.Type.AUDIO){
            Span { Text("🎤") }
        }
        Div {
            Text(note.description)
        }
    }
}