package com.tiny.url.shortener.data.di

import com.tiny.url.core.data.HttpClientFactory
import com.tiny.url.shortener.data.network.LinkShortenerDataSource
import com.tiny.url.shortener.data.repository.LinkShortenerRepositoryImpl
import com.tiny.url.shortener.domain.repository.LinkShortenerRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val shortenerDataModule = module {
    single { LinkShortenerDataSource(httpClient = HttpClientFactory.create(get())) }
    singleOf(::LinkShortenerRepositoryImpl).bind<LinkShortenerRepository>()
}