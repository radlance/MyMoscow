package com.radlance.mymoscow.data

import com.radlance.mymoscow.R
import com.radlance.mymoscow.domain.Category

object LocalStorage {
    fun getCategories(): List<Category> {
        return listOf(
            Category(R.string.historical_landmarks, R.drawable.category_historical_landmarks),
            Category(R.string.parks, R.drawable.category_parks),
            Category(R.string.museums, R.drawable.category_museums),
            Category(R.string.restaurants_and_cafes, R.drawable.category_restaurants_and_cafes),
            Category(R.string.shopping_malls, R.drawable.category_shopping_malls),
            Category(R.string.sports_facilities, R.drawable.category_sports_facilities),
            Category(R.string.science_centers, R.drawable.category_science_centeres),
            Category(R.string.science_centers, R.drawable.category_science_centeres),
            Category(R.string.walking_routes, R.drawable.category_walking_routes),
        )
    }
}