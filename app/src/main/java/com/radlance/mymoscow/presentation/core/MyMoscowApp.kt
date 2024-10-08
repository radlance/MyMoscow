package com.radlance.mymoscow.presentation.core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.radlance.mymoscow.R
import com.radlance.mymoscow.presentation.category.CategoryScreen
import com.radlance.mymoscow.presentation.place.PlaceScreen
import com.radlance.mymoscow.presentation.recommendation.RecommendationScreen

enum class ContentType {
    Default, Medium, Expanded
}

@Composable
fun MyMoscow(
    windowSize: WindowWidthSizeClass,
    mainViewModel: MainViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact -> ContentType.Default
        WindowWidthSizeClass.Medium -> ContentType.Medium
        WindowWidthSizeClass.Expanded -> ContentType.Expanded
        else -> ContentType.Default
    }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val uiState by mainViewModel.uiState.collectAsState()

    val currentScreen = Screen.valueOf(
        backStackEntry?.destination?.route ?: Screen.Start.name
    )

    Scaffold(
        topBar = {
            MyMoscowTopAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen,
                uiState = uiState,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Start.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screen.Start.name) {
                if (contentType == ContentType.Expanded) {
                    ExpandedScreen(
                        contentType = contentType,
                        onRecommendationClicked = { mainViewModel.updateCurrentPlace(it) },
                        recommendationsList = uiState.recommendations,
                        categories = uiState.categories,
                        currentRecommendation = uiState.currentRecommendation,
                        onCategoryClicked = { mainViewModel.updateCurrentCategory(it) },
                        modifier = Modifier.padding(
                            top = dimensionResource(R.dimen.padding_medium),
                            start = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium),
                        )
                    )
                } else {
                    CategoryScreen(
                        categoryList = uiState.categories,
                        onItemClicked = {
                            mainViewModel.updateCurrentCategory(it)
                            navController.navigate(Screen.Recommendations.name)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = dimensionResource(R.dimen.padding_medium),
                                start = dimensionResource(R.dimen.padding_medium),
                                end = dimensionResource(R.dimen.padding_medium),
                            )
                    )
                }
            }

            composable(Screen.Recommendations.name) {
                RecommendationScreen(
                    recommendationsList = uiState.recommendations,
                    onItemClicked = {
                        mainViewModel.updateCurrentPlace(it)
                        navController.navigate(Screen.Places.name)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(R.dimen.padding_medium),
                            start = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium),
                        )
                )
            }

            composable(Screen.Places.name) {
                PlaceScreen(
                    contentType = contentType,
                    recommendation = uiState.currentRecommendation!!,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}