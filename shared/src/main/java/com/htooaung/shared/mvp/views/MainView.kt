package com.htooaung.shared.mvp.views

import com.htooaung.shared.data.vos.RestaurantVO

interface MainView {
    fun showRestaurants(restaurants: List<RestaurantVO>)
    fun showError(error: String)
}