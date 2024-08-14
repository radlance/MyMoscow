package com.radlance.mymoscow.presentation

import androidx.lifecycle.ViewModel
import com.radlance.mymoscow.data.LocalStorage
import com.radlance.mymoscow.domain.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        UiState(categories = LocalStorage.getCategories())
    )
    val uiState: StateFlow<UiState>
        get() = _uiState.asStateFlow()

    fun updateCurrentCategory(category: Category) {
        _uiState.update { currentState ->
            currentState.copy(
                currentCategory = category,
                currentRecommendations = LocalStorage.getRecommendationsByCategoryId(category.id)
            )
        }
    }
}