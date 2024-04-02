package com.sgallego.kotlinexpert.ui.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.*
import com.sgallego.kotlinexpert.data.Filter
import com.sgallego.kotlinexpert.data.Note

@Composable
fun TopBar(onFilterClick:  (Filter) -> Unit) {
    TopAppBar(
        title = { Text("My Notes") },
        actions = {
            FilterActions(onFilterClick)
        }
    )

}

@Composable
private fun FilterActions(onFilterClick:  (Filter) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = { expanded = true }) {
        Icon(
            imageVector = Icons.Default.FilterList,
            contentDescription = "Filter"
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {

            listOf<Pair<Filter, String>>(
                Filter.All to "All",
                Filter.ByType(Note.Type.TEXT) to "Text",
                Filter.ByType(Note.Type.AUDIO) to "Audio",
            ).map { (filter, label) ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    onFilterClick(filter)
                }) {
                    Text(label)
                }
            }
        }
    }
}


