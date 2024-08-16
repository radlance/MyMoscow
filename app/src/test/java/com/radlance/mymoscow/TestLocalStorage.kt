package com.radlance.mymoscow

import com.radlance.mymoscow.data.LocalStorage
import com.radlance.mymoscow.domain.Category
import com.radlance.mymoscow.domain.Recommendation
import com.radlance.mymoscow.domain.Repository

class TestLocalStorage(private val testRecommendations: List<Recommendation>) : Repository {

    override fun getCategories(): List<Category> {
        return LocalStorage.getCategories()
    }

    override fun getRecommendationsByCategoryId(categoryId: Int): List<Recommendation> {
        return testRecommendations.filter { it.categoryId == categoryId }
    }

    override fun getBaseRecommendation(): Recommendation {
        return testRecommendations.first()
    }
}