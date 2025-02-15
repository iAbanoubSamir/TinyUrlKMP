package com.tiny.url.di

import com.tiny.url.shortener.data.di.shortenerDataModule
import com.tiny.url.shortener.domain.di.shortenerDomainModule
import com.tiny.url.shortener.presentation.di.shortenerPresentationModule
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    includes(shortenerDataModule, shortenerDomainModule, shortenerPresentationModule)
}
