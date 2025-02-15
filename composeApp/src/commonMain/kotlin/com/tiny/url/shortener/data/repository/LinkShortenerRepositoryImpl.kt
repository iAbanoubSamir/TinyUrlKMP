package com.tiny.url.shortener.data.repository

import com.tiny.url.core.domain.DataError
import com.tiny.url.core.domain.Result
import com.tiny.url.core.domain.map
import com.tiny.url.history.domain.model.Link
import com.tiny.url.shortener.data.mappers.toDomain
import com.tiny.url.shortener.data.network.LinkShortenerDataSource
import com.tiny.url.shortener.domain.repository.LinkShortenerRepository

class LinkShortenerRepositoryImpl(
    private val linkShortenerDataSource: LinkShortenerDataSource
) : LinkShortenerRepository {
    override suspend fun shortenLink(originalLink: String): Result<Link, DataError.Remote> {
        if (originalLink.isBlank()) return Result.Error(DataError.Remote.EMPTY_URL)
        if (isValidUrl(originalLink).not()) return Result.Error(DataError.Remote.INVALID_URL)
        return linkShortenerDataSource
            .shortenLink(originalLink)
            .map { it.toDomain() }
    }

    private fun isValidUrl(url: String): Boolean {
        val isNotStartingWithHttp = !url.startsWith("http://") && !url.startsWith("https://")
        val normalizedUrl = if (isNotStartingWithHttp) {
            "http://$url"
        } else url

        val urlRegex = Regex(
            "^(https?:\\/\\/)" +
                    "([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})" +
                    "(\\/[^\\s]*)?$"
        )

        return urlRegex.matches(normalizedUrl)
    }
}