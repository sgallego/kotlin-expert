package com.sgallego.kotlinexpert

fun getAppTitle() = "My notes - ${getPlatformName()}"

expect fun getPlatformName(): String