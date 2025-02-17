package com.tiny.url.shortener.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
data object LinkShortenerRoute

fun NavGraphBuilder.linkShortenerScreen() {
    composable<LinkShortenerRoute> {
        LinkShortenerScreenRoot(
            viewModel = koinViewModel<LinkShortenerViewModel>()
        )
    }
}

fun NavController.navigateToLinkShortenerScreen() {
    navigate(LinkShortenerRoute)
}