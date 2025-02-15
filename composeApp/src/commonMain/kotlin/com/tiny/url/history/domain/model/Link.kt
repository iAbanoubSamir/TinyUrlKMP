package com.tiny.url.history.domain.model

data class Link(
    val alias: String,
    val originalUrl: String,
    val tinyUrl: String,
    val createdAt: String
)
