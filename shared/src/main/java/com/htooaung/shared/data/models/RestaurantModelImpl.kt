package com.htooaung.shared.data.models

import android.annotation.SuppressLint
import com.htooaung.shared.data.vos.RestaurantVO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object RestaurantModelImpl: RestaurantModel, BaseModel(){
    @SuppressLint("CheckResult")
    override fun getRestaurants(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mRestaurantApi.getRestaurant()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(it.data ?: listOf())
            },{
                onFailure(it.localizedMessage ?: "network problem")
            })
    }

}