package com.radlance.mymoscow.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
