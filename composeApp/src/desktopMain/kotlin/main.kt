import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.concurrent.thread

fun main() {
    val state = AppState()
    application {
        Window(onCloseRequest = ::exitApplication, title = "KotlinExpertNotesDemo") {
            App(state)
        }
    }
}

class AppState(){
    val state = mutableStateOf(UiState())

    fun loadNotes(){
        thread {
            state.value = UiState(loading = true)
            getNotes {
                state.value = UiState(notes = it, loading = false)
            }
        }
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false
    )
}

@Preview
@Composable
fun AppDesktopPreview() {
    App(AppState())
}