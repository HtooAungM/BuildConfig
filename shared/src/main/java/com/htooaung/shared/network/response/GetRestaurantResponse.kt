package com.htooaung.shared.network.response

import com.google.gson.annotations.SerializedName
import com.htooaung.shared.data.vos.RestaurantVO

data class GetRestaurantResponse(
    @SerializedName("code")
    val code:Int?,
    @SerializedName("message")
    val message:String?,
    @SerializedName("data")
    val data:List<RestaurantVO>?
)