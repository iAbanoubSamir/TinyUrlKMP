package com.tiny.url.shortener.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LinkResponseDto(
    @SerialName("data") var data: LinkDataDto? = LinkDataDto(),
    @SerialName("code") var code: Int? = null,
    @SerialName("errors") var errors: ArrayList<String> = arrayListOf()
)

@Serializable
data class Analytics(
    @SerialName("enabled") var enabled: Boolean? = null,
    @SerialName("public") var public: Boolean? = null
)

@Serializable
data class LinkDataDto(
    @SerialName("domain") var domain: String? = null,
    @SerialName("alias") var alias: String? = null,
    @SerialName("deleted") var deleted: Boolean? = null,
    @SerialName("archived") var archived: Boolean? = null,
    @SerialName("analytics") var analytics: Analytics? = Analytics(),
    @SerialName("tags") var tags: ArrayList<String> = arrayListOf(),
    @SerialName("created_at") var createdAt: String? = null,
    @SerialName("expires_at") var expiresAt: String? = null,
    @SerialName("tiny_url") var tinyUrl: String? = null,
    @SerialName("url") var url: String? = null
)