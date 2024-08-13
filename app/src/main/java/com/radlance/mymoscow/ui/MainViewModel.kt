package com.radlance.mymoscow.ui

import androidx.lifecycle.ViewModel
import com.radlance.mymoscow.data.LocalStorage
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

    fun updateCurrentRecommendations(categoryId: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                currentRecommendations = LocalStorage.getRecommendationsByCategoryId(categoryId),
            )
        }
    }
}