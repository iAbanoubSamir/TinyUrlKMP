package com.tiny.url.core.domain

sealed interface DataError : Error {
    enum class Remote : DataError {
        UNAUTHORIZED,
        METHOD_NOT_ALLOWED,
        INVALID_URL,
        EMPTY_URL,
        TOO_MANY_REQUESTS,
        REQUEST_TIMEOUT,
        NO_INTERNET,
        SERVER,
        SERIALIZATION,
        UNKNOWN
    }

    enum class Local : DataError {
        DISK_FULL,
        UNKNOWN
    }
}