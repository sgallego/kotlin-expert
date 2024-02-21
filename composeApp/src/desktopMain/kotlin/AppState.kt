import androidx.compose.runtime.mutableStateOf
import kotlin.concurrent.thread

class AppState(){
    val state = mutableStateOf(UiState())

    fun loadNotes() {
        thread {
            state.update { it.copy(loading = true) }
            getNotes { notes -> state.update { UiState(notes = notes) } }
        }
    }

    data class UiState(
        val notes: List<Note>? = null, val loading: Boolean = false
    )
}