import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*

object AppState{
    var state by mutableStateOf(UiState())

    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            state = UiState(loading = true)
            state = UiState(notes = getNotes())
        }
    }

    data class UiState(
        val notes: List<Note>? = null, val loading: Boolean = false
    )
}