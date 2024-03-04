package com.example.cityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val category: Int,
    @StringRes val address: Int,
    @StringRes val description: Int,
    @DrawableRes val imageResourceId: Int,
)