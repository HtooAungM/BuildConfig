package com.htooaung.shared.data.models

import com.htooaung.shared.data.vos.RestaurantVO

interface RestaurantModel {
    fun getRestaurants(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    )
}