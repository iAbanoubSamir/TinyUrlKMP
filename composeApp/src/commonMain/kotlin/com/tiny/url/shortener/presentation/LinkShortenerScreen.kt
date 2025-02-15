package com.tiny.url.shortener.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tiny.url.core.presentation.CircularProgress
import com.tiny.url.core.presentation.TopAppBar
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import tinyurlkmp.composeapp.generated.resources.Res
import tinyurlkmp.composeapp.generated.resources.after_shorten_button
import tinyurlkmp.composeapp.generated.resources.after_shorten_long_url_title
import tinyurlkmp.composeapp.generated.resources.after_shorten_tiny_url_title
import tinyurlkmp.composeapp.generated.resources.app_name
import tinyurlkmp.composeapp.generated.resources.before_shorten_button
import tinyurlkmp.composeapp.generated.resources.before_shorten_long_url_title
import tinyurlkmp.composeapp.generated.resources.before_shorten_original_link_hint
import tinyurlkmp.composeapp.generated.resources.ic_copy

@Composable
fun LinkShortenerScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: LinkShortenerViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LinkShortenerScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
private fun LinkShortenerScreen(
    modifier: Modifier = Modifier,
    state: LinkShortenerState,
    onAction: (LinkShortenerAction) -> Unit
) {
    val isThereShortenedLink by rememberUpdatedState(!state.tinyUrl.isNullOrBlank())
    var originalLink by remember { mutableStateOf("") }

    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val errorMessage by rememberUpdatedState(state.errorMessage?.asString())

    LaunchedEffect(state.errorMessage) {
        if (state.errorMessage != null) {
            coroutineScope.launch {
                snackBarHostState.showSnackbar(message = errorMessage ?: "")
            }
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = stringResource(Res.string.app_name)
            )
        },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (isThereShortenedLink) {
                AfterShortenLinkBox(
                    originalLink = originalLink,
                    tinyUrl = state.tinyUrl ?: "",
                    onShortenAnotherClick = {
                        originalLink = ""
                        onAction(LinkShortenerAction.OnShortenAnotherClick)
                    }
                )
            } else {
                BeforeShortenLinkBox(
                    originalLink = originalLink,
                    onOriginalLinkChange = { originalLink = it },
                    onShortenClick = {
                        onAction(LinkShortenerAction.OnShortenLinkClick(originalLink))
                    }
                )
            }
        }
        if (state.isLoading) {
            CircularProgress()
        }
    }
}

@Composable
private fun AfterShortenLinkBox(
    modifier: Modifier = Modifier,
    originalLink: String,
    tinyUrl: String,
    onShortenAnotherClick: () -> Unit
) {
    val clipboardManager = LocalClipboardManager.current
    Card(
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(Res.string.after_shorten_long_url_title),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start
            )
            LinkInput(
                value = originalLink,
                readOnly = true
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(Res.string.after_shorten_tiny_url_title),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start
            )
            LinkInput(
                value = tinyUrl,
                readOnly = true,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            clipboardManager.setText(
                                annotatedString = AnnotatedString(tinyUrl)
                            )
                        }
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.ic_copy),
                            contentDescription = null,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            )

            ShortenButton(
                text = Res.string.after_shorten_button,
                onClick = { onShortenAnotherClick() }
            )
        }
    }
}

@Composable
private fun BeforeShortenLinkBox(
    modifier: Modifier = Modifier,
    originalLink: String,
    onOriginalLinkChange: (String) -> Unit,
    onShortenClick: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Card(
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                modifier = modifier,
                text = stringResource(Res.string.before_shorten_long_url_title),
                style = MaterialTheme.typography.titleMedium
            )
            LinkInput(
                value = originalLink,
                onValueChange = onOriginalLinkChange,
                placeholder = Res.string.before_shorten_original_link_hint,
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Uri,
                    imeAction = ImeAction.Done
                ),
            )
            ShortenButton(
                text = Res.string.before_shorten_button,
                onClick = { onShortenClick(originalLink) }
            )
        }
    }
}

@Composable
private fun LinkInput(
    modifier: Modifier = Modifier,
    placeholder: StringResource = Res.string.before_shorten_original_link_hint,
    value: String,
    onValueChange: (String) -> Unit = {},
    readOnly: Boolean = false,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    trailingIcon: @Composable (() -> Unit)? = null,

    ) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(stringResource(placeholder)) },
        singleLine = true,
        readOnly = readOnly,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        trailingIcon = trailingIcon
    )
}

@Composable
private fun ShortenButton(
    modifier: Modifier = Modifier,
    text: StringResource,
    onClick: () -> Unit
) {
    Button(modifier = modifier.fillMaxWidth(), onClick = onClick) {
        Text(text = stringResource(text))
    }
}