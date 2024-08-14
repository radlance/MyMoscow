package com.radlance.mymoscow.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.radlance.mymoscow.R
import com.radlance.mymoscow.ui.theme.AppTheme

enum class Screen {
    Start,
    Recommendations
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMoscowTopAppBar(
    canNavigateBack: Boolean,
    currentScreen: Screen,
    uiState: UiState,
    navigateUp: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(
                    id = determineTopBarTitle(currentScreen.name, uiState)
                ),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        }
    )
}

private fun determineTopBarTitle(currentScreenTitle: String, uiState: UiState): Int {
    return when (currentScreenTitle) {
        Screen.Recommendations.name -> uiState.currentCategory!!.titleResourceId
        else -> R.string.separated_app_name
    }
}

@Preview
@Composable
private fun MyMoscowTopAppBarPreview() {
    AppTheme {
        MyMoscowTopAppBar(
            canNavigateBack = true,
            currentScreen = Screen.Start,
            uiState = UiState(),
            navigateUp = {}
        )
    }
}