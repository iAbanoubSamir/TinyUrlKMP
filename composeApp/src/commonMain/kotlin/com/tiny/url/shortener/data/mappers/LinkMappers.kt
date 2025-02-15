package com.tiny.url.shortener.data.mappers

import com.tiny.url.history.domain.model.Link
import com.tiny.url.shortener.data.dto.LinkResponseDto
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun LinkResponseDto.toDomain() = Link(
    alias = this.data?.alias ?: "",
    originalUrl = this.data?.url ?: "",
    tinyUrl = this.data?.tinyUrl ?: "",
    createdAt = formatCreatedAt(this.data?.createdAt ?: "")
)

fun formatCreatedAt(dateString: String): String {
    val instant = Instant.parse(dateString)
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    return "${localDateTime.month.name.lowercase().replaceFirstChar { it.uppercase() }} " +
            "${localDateTime.dayOfMonth}, ${localDateTime.year} " +
            "${localDateTime.hour % 12}:${localDateTime.minute.toString().padStart(2, '0')} " +
            if (localDateTime.hour >= 12) "PM" else "AM"
}