package com.tiny.url.shortener.presentation

import com.tiny.url.core.presentation.UiText

data class LinkShortenerState(
    val originalUrl: String = "",
    val tinyUrl: String = "",
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null
)