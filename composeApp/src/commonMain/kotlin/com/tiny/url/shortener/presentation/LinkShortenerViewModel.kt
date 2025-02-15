package com.tiny.url.shortener.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiny.url.core.domain.onError
import com.tiny.url.core.domain.onSuccess
import com.tiny.url.core.presentation.asUiText
import com.tiny.url.shortener.domain.usecase.ShortenLinkUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LinkShortenerViewModel(
    private val shortenLinkUseCase: ShortenLinkUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(LinkShortenerState())
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        _state.value
    )

    fun onAction(action: LinkShortenerAction) {
        when (action) {
            is LinkShortenerAction.OnShortenLinkClick -> shortenLink(action.link)
            is LinkShortenerAction.OnShortenAnotherClick -> resetState()

        }
    }

    private fun shortenLink(originalLink: String) = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        shortenLinkUseCase(originalLink)
            .onSuccess { link ->
                _state.update {
                    it.copy(isLoading = false, errorMessage = null, tinyUrl = link.tinyUrl)
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(isLoading = false, errorMessage = error.asUiText(), tinyUrl = null)
                }
            }
    }

    private fun resetState() = viewModelScope.launch {
        _state.update { it.copy(tinyUrl = null) }
    }
}