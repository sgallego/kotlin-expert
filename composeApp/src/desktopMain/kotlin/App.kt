import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
@Preview
fun App() {
    val text = remember { mutableStateOf("") }
    val buttonEnabled = text.value.isNotEmpty()
    fun buildMessage(text: String): String{
        return "Hello $text"
    }

    MaterialTheme {
        Column {
            TextField(value = text.value, onValueChange = { newText -> text.value = newText })
            Text(text = buildMessage(text.value))
            Button(onClick = {
                text.value = ""
            }, enabled = buttonEnabled) {
                Text("Clean")
            }
        }
    }
}