package com.radlance.mymoscow.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes val titleResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
