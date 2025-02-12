package com.tiny.url

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform