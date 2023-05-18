package com.htooaung.shared.data.models

import com.htooaung.shared.network.BASE_URL_FOOD_PANDA
import com.htooaung.shared.network.RestaurantApi
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected lateinit var mRestaurantApi: RestaurantApi

    fun initRetrofitWithBaseUrl(baseurl: String){
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseurl)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        mRestaurantApi = retrofit.create(RestaurantApi::class.java)
    }
}