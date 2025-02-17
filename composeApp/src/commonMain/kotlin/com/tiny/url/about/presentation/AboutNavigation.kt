package com.tiny.url.about.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object AboutRoute

fun NavGraphBuilder.aboutScreen() {
    composable<AboutRoute> {
        AboutScreenRoot()
    }
}

fun NavController.navigateToAboutScreen() {
    navigate(AboutRoute)
}