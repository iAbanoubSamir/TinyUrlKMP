package com.tiny.url.core.presentation

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    showNavigationIcon: Boolean = false,
    onNavigateUp: () -> Unit = {},
    titleFontSize: TextUnit = 16.sp
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                fontSize = titleFontSize,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )
        },
        navigationIcon = {
            if (showNavigationIcon) {
                NavigationIcon(onClick = onNavigateUp)
            }
        }
    )
}

@Composable
private fun NavigationIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier.size(40.dp),
        onClick = onClick,
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = null,
        )
    }
}