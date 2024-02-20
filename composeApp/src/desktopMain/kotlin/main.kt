import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() {
    val state = AppState()
    application {
        Window(onCloseRequest = ::exitApplication, title = "KotlinExpertNotesDemo") {
            App(state)
        }
    }
}

class AppState(){
    val notes = mutableStateOf(getNotes())
}

@Preview
@Composable
fun AppDesktopPreview() {
    App(AppState())
}