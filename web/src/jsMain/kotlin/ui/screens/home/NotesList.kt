package ui.screens.home

import androidx.compose.runtime.Composable
import com.sgallego.kotlinexpert.data.Note
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import ui.common.Icon
import ui.theme.AppStyleSheet

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
                Icon(
                    iconName = "mic",
                    attrs = null
                )
            }
        }

        Div {
            Text(note.description)
        }
    }
}