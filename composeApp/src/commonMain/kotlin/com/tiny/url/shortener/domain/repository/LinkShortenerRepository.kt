package com.tiny.url.shortener.domain.repository

import com.tiny.url.core.domain.DataError
import com.tiny.url.core.domain.Result
import com.tiny.url.history.domain.model.Link

interface LinkShortenerRepository {
    suspend fun shortenLink(originalLink: String): Result<Link, DataError.Remote>
}