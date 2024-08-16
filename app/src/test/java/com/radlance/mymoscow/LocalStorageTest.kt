package com.radlance.mymoscow

import com.radlance.mymoscow.domain.Recommendation
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class LocalStorageTest {
    private lateinit var testRecommendations: List<Recommendation>

    @Before
    fun setup() {
        testRecommendations = listOf(
            Recommendation(
                id = 1,
                titleResourceId = R.string.gum,
                description = R.string.gum_description,
                imageResourceId = R.drawable.gum,
                categoryId = 1
            ),
            Recommendation(
                id = 2,
                titleResourceId = R.string.tsum,
                description = R.string.tsum_description,
                imageResourceId = R.drawable.tsum,
                categoryId = 1
            ),
            Recommendation(
                id = 3,
                titleResourceId = R.string.rsl,
                description = R.string.rsl_description,
                imageResourceId = R.drawable.rsl,
                categoryId = 2
            )
        )
    }

    @Test
    fun localStorage_getRecommendationsByCategoryId_RecommendationList() {
        val categoryId = 1
        val localStorage = TestLocalStorage(testRecommendations)

        val result = localStorage.getRecommendationsByCategoryId(categoryId)
        assertEquals(2, result.size)
        assertTrue(result.all { it.categoryId == categoryId })
    }

    @Test
    fun localStorage_getBaseRecommendation_FirstRecommendationsElement() {
        val localStorage = TestLocalStorage(testRecommendations)

        val result = localStorage.getBaseRecommendation()
        assertEquals(testRecommendations.first(), result)
    }

    @Test
    fun localStorage_getRecommendationsByCategoryIdWithEmptyList_EmptyList() {
        val categoryId = 1
        val localStorage = TestLocalStorage(emptyList())

        val result = localStorage.getRecommendationsByCategoryId(categoryId)
        assertTrue(result.isEmpty())
    }

    @Test(expected = NoSuchElementException::class)
    fun localStorage_getBaseRecommendationEmptyList_NoSuchElementException() {
        val localStorage = TestLocalStorage(emptyList())

        localStorage.getBaseRecommendation()
    }

    @Test
    fun localStorage_getRecommendationByCategoryIdWithNonExistentCategory_EmptyList() {
        val categoryId = 999
        val localStorage = TestLocalStorage(testRecommendations)

        val result = localStorage.getRecommendationsByCategoryId(categoryId)
        assertTrue(result.isEmpty())
    }
}