package com.radlance.mymoscow.data

import com.radlance.mymoscow.R
import com.radlance.mymoscow.domain.Category
import com.radlance.mymoscow.domain.Recommendation
import com.radlance.mymoscow.domain.Repository

object LocalStorage : Repository {
    override fun getCategories(): List<Category> {
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

    private var allRecommendations = listOf(
      Recommendation(1, R.string.red_square, R.string.red_square_description, R.drawable.red_square, 1),
      Recommendation(2, R.string.moscow_kremlin, R.string.moscow_kremlin_description, R.drawable.moscow_kremlin, 1),
      Recommendation(3, R.string.st_basils_cathedral, R.string.st_basils_cathedral_description, R.drawable.st_basils_cathedral, 1),
      Recommendation(4, R.string.bolshoi_theatre, R.string.bolshoi_theatre_description, R.drawable.bolshoi_theatre, 1),
      Recommendation(5, R.string.tretyakov_gallery, R.string.tretyakov_gallery_description, R.drawable.tretyakov_gallery, 1),
      Recommendation(6, R.string.gorky_park, R.string.gorky_park_description, R.drawable.gorky_park, 2),
      Recommendation(7, R.string.zaryadye_park, R.string.zaryadye_park_description, R.drawable.zaryadye_park, 2),
      Recommendation(8, R.string.vdnkh, R.string.vdnkh_description, R.drawable.vdnkh, 2),
      Recommendation(9, R.string.msu_botanical_garden, R.string.msu_botanical_garden_description, R.drawable.msu_botanical_garden, 2),
      Recommendation(10, R.string.sokolniki_park, R.string.sokolniki_park_description, R.drawable.sokolniki_park, 2),
      Recommendation(11, R.string.state_historical_museum, R.string.state_historical_museum_description, R.drawable.state_historical_museum, 3),
      Recommendation(12, R.string.garage_museum, R.string.garage_museum_description, R.drawable.garage_museum, 3),
      Recommendation(13, R.string.polytechnic_museum, R.string.polytechnic_museum_description, R.drawable.polytechnic_museum, 3),
      Recommendation(14, R.string.museum_of_cosmonautics, R.string.museum_of_cosmonautics_description, R.drawable.museum_of_cosmonautics, 3),
      Recommendation(15, R.string.tsaritsyno_museum_reserve, R.string.tsaritsyno_museum_reserve_description, R.drawable.tsaritsyno_museum_reserve, 3),
      Recommendation(16, R.string.white_rabbit, R.string.white_rabbit_description, R.drawable.white_rabbit, 4),
      Recommendation(17, R.string.cafe_pushkin, R.string.cafe_pushkin_description, R.drawable.cafe_pushkin, 4),
      Recommendation(18, R.string.lavkalavka, R.string.lavkalavka_description, R.drawable.lavkalavka, 4),
      Recommendation(19, R.string.selfie, R.string.selfie_description, R.drawable.selfie, 4),
      Recommendation(20, R.string.turandot, R.string.turandot_description, R.drawable.turandot, 4),
      Recommendation(21, R.string.gum, R.string.gum_description, R.drawable.gum, 5),
      Recommendation(22, R.string.tsum, R.string.tsum_description, R.drawable.tsum, 5),
      Recommendation(23, R.string.european_shopping_center, R.string.european_shopping_center_description, R.drawable.european_shopping_center, 5),
      Recommendation(24, R.string.afimall_city, R.string.afimall_city_description, R.drawable.afimall_city, 5),
      Recommendation(25, R.string.central_market, R.string.central_market_description, R.drawable.central_market, 5),
      Recommendation(26, R.string.luzhniki_stadium, R.string.luzhniki_stadium_description, R.drawable.luzhniki_stadium, 6),
      Recommendation(27, R.string.olympic_complex, R.string.olympic_complex_description, R.drawable.olympic_complex, 6),
      Recommendation(28, R.string.vtb_arena, R.string.vtb_arena_description, R.drawable.vtb_arena, 6),
      Recommendation(29, R.string.cska_arena, R.string.cska_arena_description, R.drawable.cska_arena, 6),
      Recommendation(30, R.string.otkritie_arena, R.string.otkritie_arena_description, R.drawable.otkritie_arena, 6),
      Recommendation(31, R.string.msu, R.string.msu_description, R.drawable.msu, 7),
      Recommendation(32, R.string.rsl, R.string.rsl_description, R.drawable.rsl, 7),
      Recommendation(33, R.string.planetarium, R.string.planetarium_description, R.drawable.planetarium, 7),
      Recommendation(34, R.string.moscow_zoo, R.string.moscow_zoo_description, R.drawable.moscow_zoo, 7),
      Recommendation(35, R.string.experimentanium, R.string.experimentanium_description, R.drawable.experimentanium, 7),
      Recommendation(36, R.string.moscow_river, R.string.moscow_river_description, R.drawable.moscow_river, 8),
      Recommendation(37, R.string.arbat_street, R.string.arbat_street_description, R.drawable.arbat_street, 8),
      Recommendation(38, R.string.boulevard_ring, R.string.boulevard_ring_description, R.drawable.boulevard_ring, 8),
      Recommendation(39, R.string.patriarchs_ponds, R.string.patriarchs_ponds_description, R.drawable.patriarchs_ponds, 8),
      Recommendation(40, R.string.ostozhenka_street, R.string.ostozhenka_street_description, R.drawable.ostozhenka_street, 8)
    )

    override fun getRecommendationsByCategoryId(categoryId: Int): List<Recommendation> {
        return allRecommendations.filter { it.categoryId == categoryId }
    }

    override fun getBaseRecommendation(): Recommendation {
        return allRecommendations.first()
    }
}