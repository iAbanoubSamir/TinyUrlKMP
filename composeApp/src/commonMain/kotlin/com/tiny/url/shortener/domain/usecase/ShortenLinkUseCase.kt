package com.tiny.url.shortener.domain.usecase

import com.tiny.url.shortener.domain.repository.LinkShortenerRepository

class ShortenLinkUseCase(
    private val linkShortenerRepository: LinkShortenerRepository
) {
    suspend operator fun invoke(originalLink: String) =
        linkShortenerRepository.shortenLink(originalLink)
}