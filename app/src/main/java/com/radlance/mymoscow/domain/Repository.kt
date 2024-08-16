package com.radlance.mymoscow.domain

interface Repository {
    fun getCategories(): List<Category>
    fun getRecommendationsByCategoryId(categoryId: Int): List<Recommendation>
    fun getBaseRecommendation(): Recommendation
}