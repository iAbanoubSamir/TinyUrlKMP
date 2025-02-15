package com.tiny.url

import androidx.compose.ui.window.ComposeUIViewController
import com.tiny.url.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}