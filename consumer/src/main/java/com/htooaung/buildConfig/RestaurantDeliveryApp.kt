package com.htooaung.buildConfig

import android.app.Application
import com.htooaung.shared.data.models.RestaurantModelImpl

class RestaurantDeliveryApp: Application() {
    override fun onCreate() {
        super.onCreate()
        RestaurantModelImpl.initRetrofitWithBaseUrl(BuildConfig.ENDPOINT) //if foodPanda is selected in Build Variants -> End point is for foodPanda
    }
}