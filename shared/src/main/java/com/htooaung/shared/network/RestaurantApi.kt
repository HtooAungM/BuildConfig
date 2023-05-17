package com.htooaung.shared.network

import com.htooaung.shared.network.response.GetRestaurantResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface RestaurantApi {
    @GET(API_GET_RESTAURANTS)
    fun getRestaurant(): Observable<GetRestaurantResponse>
}