package com.tiny.url

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tiny.url.shortener.presentation.LinkShortenerRoute
import com.tiny.url.shortener.presentation.linkShortenerScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = LinkShortenerRoute
        ) {
            linkShortenerScreen()
        }
    }
}