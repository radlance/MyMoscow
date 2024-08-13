package com.radlance.mymoscow.ui

import com.radlance.mymoscow.domain.Category
import com.radlance.mymoscow.domain.Recommendation

data class UiState(
    val categories: List<Category> = emptyList(),
    var currentRecommendations: List<Recommendation> = emptyList()
)
