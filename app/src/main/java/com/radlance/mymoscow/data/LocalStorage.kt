package com.radlance.mymoscow.data

import com.radlance.mymoscow.R
import com.radlance.mymoscow.domain.Category
import com.radlance.mymoscow.domain.Recommendation

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

    private val allRecommendations = listOf(
      Recommendation(1, R.string.red_square, R.drawable.red_square, 1),
      Recommendation(2, R.string.moscow_kremlin, R.drawable.moscow_kremlin, 1),
      Recommendation(3, R.string.st_basils_cathedral, R.drawable.st_basils_cathedral, 1),
      Recommendation(4, R.string.bolshoi_theatre, R.drawable.bolshoi_theatre, 1),
      Recommendation(5, R.string.tretyakov_gallery, R.drawable.tretyakov_gallery, 1),
      Recommendation(6, R.string.gorky_park, R.drawable.gorky_park, 2),
      Recommendation(7, R.string.zaryadye_park, R.drawable.zaryadye_park, 2),
      Recommendation(8, R.string.vdnkh, R.drawable.vdnkh, 2),
      Recommendation(9, R.string.msu_botanical_garden, R.drawable.msu_botanical_garden, 2),
      Recommendation(10, R.string.sokolniki_park, R.drawable.sokolniki_park, 2),
      Recommendation(11, R.string.state_historical_museum, R.drawable.state_historical_museum, 3),
      Recommendation(12, R.string.garage_museum, R.drawable.garage_museum, 3),
      Recommendation(13, R.string.polytechnic_museum, R.drawable.polytechnic_museum, 3),
      Recommendation(14, R.string.museum_of_cosmonautics, R.drawable.museum_of_cosmonautics, 3),
      Recommendation(15, R.string.tsaritsyno_museum_reserve, R.drawable.tsaritsyno_museum_reserve, 3),
      Recommendation(16, R.string.white_rabbit, R.drawable.white_rabbit, 4),
      Recommendation(17, R.string.cafe_pushkin, R.drawable.cafe_pushkin, 4),
      Recommendation(18, R.string.lavkalavka, R.drawable.lavkalavka, 4),
      Recommendation(19, R.string.selfie, R.drawable.selfie, 4),
      Recommendation(20, R.string.turandot, R.drawable.turandot, 4),
      Recommendation(21, R.string.gum, R.drawable.gum, 5),
      Recommendation(22, R.string.tsum, R.drawable.tsum, 5),
      Recommendation(23, R.string.european_shopping_center, R.drawable.european_shopping_center, 5),
      Recommendation(24, R.string.afimall_city, R.drawable.afimall_city, 5),
      Recommendation(25, R.string.central_market, R.drawable.central_market, 5),
      Recommendation(26, R.string.luzhniki_stadium, R.drawable.luzhniki_stadium, 6),
      Recommendation(27, R.string.olympic_complex, R.drawable.olympic_complex, 6),
      Recommendation(28, R.string.vtb_arena, R.drawable.vtb_arena, 6),
      Recommendation(29, R.string.cska_arena, R.drawable.cska_arena, 6),
      Recommendation(30, R.string.otkritie_arena, R.drawable.otkritie_arena, 6),
      Recommendation(31, R.string.msu, R.drawable.msu, 7),
      Recommendation(32, R.string.rsl, R.drawable.rsl, 7),
      Recommendation(33, R.string.planetarium, R.drawable.planetarium, 7),
      Recommendation(34, R.string.moscow_zoo, R.drawable.moscow_zoo, 7),
      Recommendation(35, R.string.experimentanium, R.drawable.experimentanium, 7),
      Recommendation(36, R.string.moscow_river, R.drawable.moscow_river, 8),
      Recommendation(37, R.string.arbat_street, R.drawable.arbat_street, 8),
      Recommendation(38, R.string.boulevard_ring, R.drawable.boulevard_ring, 8),
      Recommendation(39, R.string.patriarchs_ponds, R.drawable.patriarchs_ponds, 8),
      Recommendation(40, R.string.ostozhenka_street, R.drawable.ostozhenka_street, 8)
    )

    fun getRecommendationsByCategoryId(categoryId: Int): List<Recommendation> {
        return allRecommendations.filter { it.categoryId == categoryId }
    }
}