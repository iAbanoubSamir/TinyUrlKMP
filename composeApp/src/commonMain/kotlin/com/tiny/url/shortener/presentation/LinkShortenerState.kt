package com.tiny.url.shortener.presentation

import com.tiny.url.core.presentation.UiText

data class LinkShortenerState(
    val tinyUrl: String? = "",
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null
)