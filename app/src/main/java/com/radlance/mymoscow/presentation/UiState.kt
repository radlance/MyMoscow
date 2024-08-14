package com.radlance.mymoscow.presentation

import com.radlance.mymoscow.domain.Category
import com.radlance.mymoscow.domain.Recommendation

data class UiState(
    val categories: List<Category> = emptyList(),
    val currentCategory: Category? = null,
    var currentRecommendations: List<Recommendation> = emptyList()
)
