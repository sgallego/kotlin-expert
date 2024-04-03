package com.sgallego.kotlinexpert.ui

sealed interface Route {
    data object Home : Route
    data class Detail(val id: Long) : Route
}