package com.tiny.url

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.tiny.url.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Tiny URL",
        ) {
            App()
        }
    }
}