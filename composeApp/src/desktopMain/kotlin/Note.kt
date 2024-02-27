import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class Note(
    val title: String,
    val description: String,
    val type: Type
) {

    enum class Type {
        TEXT, AUDIO
    }

}


suspend fun getNotes(): Flow<List<Note>> = flow {
    delay(2000)
    var notes = emptyList<Note>()
    (0..10).forEach {
        notes = notes + Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
        emit(notes)
        delay(500)
    }

}