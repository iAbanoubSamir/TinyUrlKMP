package com.tiny.url.shortener.domain.di

import com.tiny.url.shortener.domain.usecase.ShortenLinkUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val shortenerDomainModule = module {
    singleOf(::ShortenLinkUseCase)
}