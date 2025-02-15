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
        return linkShortenerDataSource
            .shortenLink(originalLink)
            .map { it.toDomain() }
    }
}