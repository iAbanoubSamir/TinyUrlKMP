package com.tiny.url.shortener.presentation.di

import com.tiny.url.shortener.presentation.LinkShortenerViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val shortenerPresentationModule = module {
    viewModelOf(::LinkShortenerViewModel)
}