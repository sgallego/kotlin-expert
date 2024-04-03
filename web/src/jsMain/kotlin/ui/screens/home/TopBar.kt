package ui.screens.home

import androidx.compose.runtime.*
import com.sgallego.kotlinexpert.data.Filter
import com.sgallego.kotlinexpert.data.Note
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text
import ui.common.Icon
import ui.theme.AppStyleSheet

@Composable
fun TopBar(onFilterClick:  (Filter) -> Unit) {
    Div(attrs = {
        classes(AppStyleSheet.topBar)
    }){
        H1(attrs = {
            classes(AppStyleSheet.topBarTitle)
        }){ Text("Mis notas")   }
        FiltersActions(onFilterClick)
    }
}

@Composable
fun FiltersActions(onFilterClick: (Filter) -> Unit){
    var expanded by remember { mutableStateOf(false) }

    Div(attrs = {
        classes(AppStyleSheet.filtersAction)
    }) {
        Div(attrs = {
            style {
                color(Color.white)
            }
            onClick { expanded = true }
        }){
            Icon(
                iconName = "search",
                attrs = {
                    classes(AppStyleSheet.topBarIcon)
                }
            )
        }
        if(expanded){
            Div(attrs = {
                classes(AppStyleSheet.filtersActionExpanded)
            }) {
                listOf<Pair<Filter, String>>(
                    Filter.All to "All",
                    Filter.ByType(Note.Type.TEXT) to "Text",
                    Filter.ByType(Note.Type.AUDIO) to "Audio",
                ).forEach { (filter, label) ->
                    Div(attrs = {
                        classes(AppStyleSheet.filtersActionExpandedItem)
                        onClick {
                            onFilterClick(filter)
                            expanded = false
                        }
                    }) {
                        Text(label)
                    }
                }
            }


        }
    }
}