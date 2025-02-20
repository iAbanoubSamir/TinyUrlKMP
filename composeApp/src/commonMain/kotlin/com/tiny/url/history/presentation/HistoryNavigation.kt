package com.tiny.url.history.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object HistoryRoute

fun NavGraphBuilder.historyScreen() {
    composable<HistoryRoute> {
        // TODO: Add history screen root
    }
}

fun NavController.navigateToHistoryScreen() {
    navigate(HistoryRoute)
}