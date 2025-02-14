package com.tiny.url.shortener.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LinkShortenerViewModel : ViewModel() {
    private val _state = MutableStateFlow(LinkShortenerState())
    val state = _state.asStateFlow()

    fun onAction(action: LinkShortenerAction) {
        when (action) {
            is LinkShortenerAction.OnShortenLinkClick -> {}
            is LinkShortenerAction.OnShortenAnotherClick -> {}
        }
    }
}