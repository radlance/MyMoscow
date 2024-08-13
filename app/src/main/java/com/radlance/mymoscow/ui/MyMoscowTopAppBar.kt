package com.radlance.mymoscow.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.radlance.mymoscow.R
import com.radlance.mymoscow.ui.theme.AppTheme


enum class MyMoscowScreen(@StringRes val title: Int) {
    Start(R.string.separated_app_name)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMoscowTopAppBar(
    canNavigateBack: Boolean,
    currentScreen: MyMoscowScreen,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = currentScreen.title)) },
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

@Preview
@Composable
private fun MyMoscowTopAppBarPreview() {
    AppTheme {
        MyMoscowTopAppBar(
            canNavigateBack = true,
            currentScreen = MyMoscowScreen.Start,
            navigateUp = {})
    }
}