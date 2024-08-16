package com.radlance.mymoscow

import com.radlance.mymoscow.data.LocalStorage
import com.radlance.mymoscow.domain.Category
import com.radlance.mymoscow.domain.Recommendation
import com.radlance.mymoscow.presentation.core.MainViewModel
import com.radlance.mymoscow.presentation.core.UiState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class MainViewModelTest {
    private lateinit var viewModel: MainViewModel
    private lateinit var testCategory: Category
    private lateinit var testRecommendation: Recommendation

    @Test
    fun mainViewModel_Initialization_CategoriesLoaded() {
        val uiState = viewModel.uiState.value
        val categories = LocalStorage.getCategories()

        assertEquals(categories, uiState.categories)
    }

    @Before
    fun setup() {
        viewModel = MainViewModel()

        testCategory = Category(
            id = 1,
            titleResourceId = R.string.categories,
            imageResourceId = R.drawable.category_parks
        )

        testRecommendation = Recommendation(
            id = 1,
            titleResourceId = R.string.gum,
            description = R.string.gum_description,
            imageResourceId = R.drawable.gum,
            categoryId = 1
        )
    }

    @Test
    fun uiState_DefaultValues_CheckNullOrEmpty() {
        val uiState = UiState()
        assertNull(uiState.currentCategory)
        assertNull(uiState.currentRecommendation)

        assertEquals(uiState.categories, emptyList<Category>())
        assertEquals(uiState.recommendations, emptyList<Recommendation>())
    }

    @Test
    fun mainViewModel_UpdateCurrentCategory_UiStateUpdated() {
        viewModel.updateCurrentCategory(category = testCategory)
        assertEquals(testCategory, viewModel.uiState.value.currentCategory)
    }

    @Test
    fun mainViewModel_UpdateCurrentPlace_UiStateUpdated() {
        viewModel.updateCurrentPlace(recommendation = testRecommendation)
        assertEquals(testRecommendation, viewModel.uiState.value.currentRecommendation)
    }

    @Test
    fun mainViewModel_SequentialUpdate_saveAllData() {
        viewModel.updateCurrentCategory(category = testCategory)
        viewModel.updateCurrentPlace(recommendation = testRecommendation)

        assertEquals(testCategory, viewModel.uiState.value.currentCategory)
        assertEquals(testRecommendation, viewModel.uiState.value.currentRecommendation)
    }
}