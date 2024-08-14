package com.radlance.mymoscow.presentation.core

import com.radlance.mymoscow.domain.Category
import com.radlance.mymoscow.domain.Recommendation

data class UiState(
    val categories: List<Category> = emptyList(),
    val currentCategory: Category? = null,
    var recommendations: List<Recommendation> = emptyList(),
    var currentRecommendation: Recommendation? = null
)
