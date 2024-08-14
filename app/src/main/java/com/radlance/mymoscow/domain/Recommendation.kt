package com.radlance.mymoscow.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val description: Int,
    @DrawableRes val imageResourceId: Int,
    val categoryId: Int
)