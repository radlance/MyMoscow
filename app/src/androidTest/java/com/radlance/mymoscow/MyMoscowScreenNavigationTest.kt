package com.radlance.mymoscow

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.espresso.Espresso.pressBack
import com.radlance.mymoscow.data.LocalStorage
import com.radlance.mymoscow.presentation.core.MyMoscow
import com.radlance.mymoscow.presentation.core.Screen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MyMoscowScreenNavigationTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            MyMoscow(
                windowSize = WindowWidthSizeClass.Compact,
                navController = navController
            )
        }
    }

    @Test
    fun navHost_verifyCurrentDestination() {
        navController.assertCurrentDestination(Screen.Start.name)
    }

    @Test
    fun navHost_verifyBackNavigationNotShownOnStartScreen() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }

    @Test
    fun navHost_clickFirstElementOnStartScreen_navigatesToRecommendationScreen() {
        navigateToRecommendationScreen()
        navController.assertCurrentDestination(Screen.Recommendations.name)
    }

    @Test
    fun navHost_verifyBackNavigationShownOnRecommendationScreen() {
        navigateToRecommendationScreen()
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).assertExists()
    }

    @Test
    fun navHost_clickUpButtonOnRecommendationScreen_navigatesToStartScreen() {
        navigateToRecommendationScreen()
        performNavigateUp()
        navController.assertCurrentDestination(Screen.Start.name)
    }

    @Test
    fun navHost_clickDeviceBackButtonOnOnRecommendationScreen_navigatesToStartScreen() {
        navigateToRecommendationScreen()
        pressBack()
        navController.assertCurrentDestination(Screen.Start.name)
    }

    @Test
    fun navHost_clickFirstElementOnRecommendationScreen_navigatesToPlaceScreen() {
        navigateToPlaceScreen()
        navController.assertCurrentDestination(Screen.Places.name)
    }

    @Test
    fun navHost_clickUpButtonOnPlaceScreen_navigatesToRecommendationScreen() {
        navigateToPlaceScreen()
        performNavigateUp()
        navController.assertCurrentDestination(Screen.Recommendations.name)
    }

    @Test
    fun navHost_clickDeviceBackButtonOnPlaceScreen_navigatesToRecommendationScreen() {
        navigateToPlaceScreen()
        pressBack()
        navController.assertCurrentDestination(Screen.Recommendations.name)
    }

    @Test
    fun navHost_clickUpButtonStartingFromPlaceScreen_navigatesToStartScreen() {
        navigateToPlaceScreen()
        performNavigateUp()
        performNavigateUp()
        navController.assertCurrentDestination(Screen.Start.name)
    }

    private fun navigateToRecommendationScreen() {
        composeTestRule.onNodeWithStringId(
            LocalStorage.getCategories()[0].titleResourceId
        ).performClick()
    }

    private fun navigateToPlaceScreen() {
        navigateToRecommendationScreen()
        composeTestRule.onNodeWithStringId(
            LocalStorage.getBaseRecommendation().titleResourceId
        ).performClick()
    }

    private fun performNavigateUp() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).performClick()
    }
}
