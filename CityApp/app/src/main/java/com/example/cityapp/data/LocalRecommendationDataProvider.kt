package com.example.cityapp.data

import com.example.cityapp.R
import com.example.cityapp.model.Recommendation


object LocalRecommendationDataProvider {
    val recommendations: List<Recommendation> = listOf(
        Recommendation(
            id = 1,
            name = R.string.tc_1,
            category = R.string.category_1,
            address = R.string.tc_address_1,
            description = R.string.tc_description_1,
            imageResourceId = R.drawable.tc_1
        ),
        Recommendation(
            id = 2,
            name = R.string.tc_2,
            category = R.string.category_1,
            address = R.string.tc_address_2,
            description = R.string.tc_description_2,
            imageResourceId = R.drawable.tc_2
        ),
        Recommendation(
            id = 3,
            name = R.string.tc_3,
            category = R.string.category_1,
            address = R.string.tc_address_3,
            description = R.string.tc_description_3,
            imageResourceId = R.drawable.tc_3
        ),
        Recommendation(
            id = 4,
            name = R.string.metro_1,
            category = R.string.category_2,
            address = R.string.metro_address_1,
            description = R.string.metro_description_1,
            imageResourceId = R.drawable.metro_1
        ),
        Recommendation(
            id = 5,
            name = R.string.metro_2,
            category = R.string.category_2,
            address = R.string.metro_address_2,
            description = R.string.metro_description_2,
            imageResourceId = R.drawable.metro_2
        ),
        Recommendation(
            id = 6,
            name = R.string.metro_3,
            category = R.string.category_2,
            address = R.string.metro_address_3,
            description = R.string.metro_description_3,
            imageResourceId = R.drawable.metro_3
        ),
        Recommendation(
            id = 7,
            name = R.string.park_1,
            category = R.string.category_3,
            address = R.string.park_address_1,
            description = R.string.park_description_1,
            imageResourceId = R.drawable.park_1
        ),
        Recommendation(
            id = 8,
            name = R.string.park_2,
            category = R.string.category_3,
            address = R.string.park_address_2,
            description = R.string.park_description_2,
            imageResourceId = R.drawable.park_2
        ),
        Recommendation(
            id = 9,
            name = R.string.park_3,
            category = R.string.category_3,
            address = R.string.park_address_3,
            description = R.string.park_description_3,
            imageResourceId = R.drawable.park_3
        ),
        Recommendation(
            id = 10,
            name = R.string.shop_1,
            category = R.string.category_4,
            address = R.string.shop_address_1,
            description = R.string.shop_description_1,
            imageResourceId = R.drawable.shop_1
        ),
        Recommendation(
            id = 11,
            name = R.string.shop_2,
            category = R.string.category_4,
            address = R.string.shop_address_2,
            description = R.string.shop_description_2,
            imageResourceId = R.drawable.shop_2
        ),
        Recommendation(
            id = 12,
            name = R.string.shop_3,
            category = R.string.category_4,
            address = R.string.shop_address_3,
            description = R.string.shop_description_3,
            imageResourceId = R.drawable.shop_3
        ),
        Recommendation(
            id = 13,
            name = R.string.fastfood_1,
            category = R.string.category_5,
            address = R.string.fastfood_address_1,
            description = R.string.fastfood_description_1,
            imageResourceId = R.drawable.fastfood_1
        ),
        Recommendation(
            id = 14,
            name = R.string.fastfood_2,
            category = R.string.category_5,
            address = R.string.fastfood_address_2,
            description = R.string.fastfood_description_2,
            imageResourceId = R.drawable.fastfood_2
        ),
        Recommendation(
            id = 15,
            name = R.string.fastfood_3,
            category = R.string.category_5,
            address = R.string.fastfood_address_3,
            description = R.string.fastfood_description_3,
            imageResourceId = R.drawable.fastfood_3
        )
    )
}
