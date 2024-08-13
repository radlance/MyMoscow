package com.radlance.mymoscow.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.radlance.mymoscow.R
import com.radlance.mymoscow.data.LocalStorage

@Composable
fun MyMoscow(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyMoscowScreen.valueOf(
        backStackEntry?.destination?.route ?: MyMoscowScreen.Start.name
    )

    Scaffold(
        topBar = {
            MyMoscowTopAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = MyMoscowScreen.Start.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = MyMoscowScreen.Start.name) {
                CategoryList(
                    categoryList = LocalStorage.getCategories(),
                    onItemClicked = {},
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
    }
}