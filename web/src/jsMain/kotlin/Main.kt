import androidx.compose.runtime.*
import com.sgallego.kotlinexpert.data.Note
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
    Div(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            gap(16.px)
            width(100.percent)
            height(100.percent)
            alignItems(AlignItems.Center)
        }
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
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                width(80.percent)
                maxWidth(600.px)
                marginTop(8.px)
                marginBottom(8.px)
                padding(16.px)
                border(1.px, LineStyle.Solid, Color.black)
                borderRadius(4.px)
                cursor("pointer")
            }
        }
    ) {
        Div(
            attrs = {
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Row)
                    alignItems(AlignItems.Center)
                    width(100.percent)
                }
            }
        ) {
            H3(
                attrs = {
                    style {
                        flex(1)
                    }
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