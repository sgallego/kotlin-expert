package ui.screens.detail

import androidx.compose.runtime.*
import com.sgallego.kotlinexpert.data.Note
import com.sgallego.kotlinexpert.ui.screens.detail.DetailViewModel
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.selected
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import ui.theme.AppStyleSheet

@Composable
fun Detail(vm: DetailViewModel, id: Long, onClose: () -> Unit) {

    val note = vm.state.note

    Div {
        TopBar(
            note = note,
            onClose = onClose,
            onSave = vm::save,
            onDelete = vm::delete
        )

        if(vm.state.saved){
            onClose()
        }

        if(vm.state.loading){
            Text("Loading...")
        }else{
            Div(
                attrs = {
                    style {
                        padding(32.px)
                        display(DisplayStyle.Flex)
                        flexDirection(FlexDirection.Column)
                        gap(16.px)
                        maxWidth(600.px)
                        property("margin", "0 auto")
                    }
                }
            ) {
                TextInput(
                    value = note.title,
                    attrs = {
                        classes(AppStyleSheet.detailInput)
                        placeholder("Title")
                        onInput { vm.update(note.copy(title = it.value)) }
                    }
                )
                TypeDropdown(
                    value = note.type,
                    onValueChange = {
                        vm.update(note.copy(type = it))
                    }
                )
                TextArea(
                    value = note.description,
                    attrs = {
                        classes(AppStyleSheet.detailInput)
                        placeholder("Description")
                        onInput { vm.update(note.copy(description = it.value)) }
                    }
                )
            }
        }
    }

}

@Composable
private fun TypeDropdown(value: Note.Type, onValueChange: (Note.Type) -> Unit) {
    Select(
        attrs = {
            classes(AppStyleSheet.detailInput)
            onChange { onValueChange(Note.Type.valueOf(it.target.value)) }
        }
    ){
        Note.Type.entries.forEach {
            Option(
                value = it.name,
                attrs = {
                    if (it == value) {
                        selected()
                    }
                }
            ) {
                Text(it.name)
            }
        }
    }
}

@Composable
private fun TopBar(note: Note, onClose: () -> Unit, onSave: () -> Unit, onDelete: () -> Unit) {
    Div(
        attrs = {
            classes(AppStyleSheet.topBar)
        }
    ) {
        Button(
            attrs = {
                onClick { onClose() }
            }
        ) {
            Text("Close Detail")
        }
        H1(
            attrs = {
                classes(AppStyleSheet.topBarTitle)
            }
        ) {
            Text(note.title)
        }

        Button(
            attrs = {
                onClick { onSave() }
            }
        ) {
            Text("Save note")
        }

        if(note.id != Note.NEW_NOTE) {
            Button(
                attrs = {
                    onClick { onDelete() }
                }
            ) {
                Text("Delete note")
            }
        }
    }
}

