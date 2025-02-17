package com.tiny.url

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tiny.url.about.presentation.aboutScreen
import com.tiny.url.about.presentation.navigateToAboutScreen
import com.tiny.url.history.presentation.HistoryRoute
import com.tiny.url.shortener.presentation.LinkShortenerRoute
import com.tiny.url.shortener.presentation.linkShortenerScreen
import com.tiny.url.shortener.presentation.navigateToLinkShortenerScreen
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tinyurlkmp.composeapp.generated.resources.Res
import tinyurlkmp.composeapp.generated.resources.nav_about
import tinyurlkmp.composeapp.generated.resources.nav_history
import tinyurlkmp.composeapp.generated.resources.nav_home

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    var selectedScreen by remember { mutableStateOf(Screen.HOME) }

    MaterialTheme {
        NavigationSuiteScaffold(
            navigationSuiteItems = {
                Screen.entries.forEach { screen ->
                    item(
                        selected = selectedScreen == screen,
                        onClick = {
                            selectedScreen = screen
                            when (screen) {
                                Screen.HOME -> navController.navigateToLinkShortenerScreen()
                                Screen.HISTORY -> navController.navigate(HistoryRoute)
                                Screen.ABOUT -> navController.navigateToAboutScreen()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = stringResource(screen.title)
                            )
                        },
                        label = { Text(stringResource(screen.title)) }
                    )
                }
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = LinkShortenerRoute
            ) {
                linkShortenerScreen()

                aboutScreen()
            }
        }
    }
}

enum class Screen(val title: StringResource, val icon: ImageVector) {
    HOME(Res.string.nav_home, Icons.Rounded.Home),
    HISTORY(Res.string.nav_history, Icons.AutoMirrored.Rounded.List),
    ABOUT(Res.string.nav_about, Icons.Rounded.Info)
}