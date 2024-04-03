package ui.screens.detail

import androidx.compose.runtime.*
import com.sgallego.kotlinexpert.ui.screens.detail.DetailViewModel
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Detail(vm: DetailViewModel, id: Long, onClose: () -> Unit) {
    Div {
        Text("Detail")
    }

}