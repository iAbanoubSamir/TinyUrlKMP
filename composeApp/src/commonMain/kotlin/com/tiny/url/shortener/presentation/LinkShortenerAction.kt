package com.tiny.url.shortener.presentation

sealed interface LinkShortenerAction {
    data class OnShortenLinkClick(val link: String) : LinkShortenerAction
    data object OnShortenAnotherClick : LinkShortenerAction
}