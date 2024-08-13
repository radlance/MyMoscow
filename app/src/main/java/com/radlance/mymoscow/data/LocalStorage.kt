package com.radlance.mymoscow.data

import com.radlance.mymoscow.R
import com.radlance.mymoscow.domain.Category

object LocalStorage {
    fun getCategories(): List<Category> {
        return listOf(
            Category(1, R.string.historical_landmarks, R.drawable.category_historical_landmarks),
            Category(2, R.string.parks, R.drawable.category_parks),
            Category(3, R.string.museums, R.drawable.category_museums),
            Category(4, R.string.restaurants_and_cafes, R.drawable.category_restaurants_and_cafes),
            Category(5, R.string.shopping_malls, R.drawable.category_shopping_malls),
            Category(6, R.string.sports_facilities, R.drawable.category_sports_facilities),
            Category(7, R.string.science_centers, R.drawable.category_science_centeres),
            Category(8, R.string.walking_routes, R.drawable.category_walking_routes),
        )
    }
}