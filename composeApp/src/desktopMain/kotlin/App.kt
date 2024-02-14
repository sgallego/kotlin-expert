import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable

@Composable
@Preview
fun App(state: AppState) {
    fun buildMessage(text: String): String{
        return "Hello $text"
    }

    MaterialTheme {
        Column {
            TextField(value = state.text.value, onValueChange = { newText -> state.text.value = newText })
            Text(text = buildMessage(state.text.value))
            Button(onClick = {
                state.text.value = ""
            }, enabled = state.buttonEnabled()) {
                Text("Clean")
            }
        }
    }
}