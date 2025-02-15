package com.tiny.url.shortener.data.network

import com.tiny.url.core.data.safeCall
import com.tiny.url.core.domain.DataError
import com.tiny.url.core.domain.Result
import com.tiny.url.shortener.data.dto.LinkResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.post

private const val BASE_URL = "https://api.tinyurl.com"

class LinkShortenerDataSource(
    private val httpClient: HttpClient
) {
    suspend fun shortenLink(
        originalLink: String
    ): Result<LinkResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.post(
                urlString = "$BASE_URL/create"
            ) {
                parameter("api_token", "YOUR_API_KEY")
                parameter("url", originalLink)
            }
        }
    }
}