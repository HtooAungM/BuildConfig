package com.htooaung.shared.mvp.presenters

import androidx.lifecycle.ViewModel
import com.htooaung.shared.data.models.RestaurantModel
import com.htooaung.shared.data.models.RestaurantModelImpl
import com.htooaung.shared.mvp.views.MainView

class MainPresenterImpl: MainPresenter,ViewModel() {
    var mView: MainView? = null
    //Model
    private val mRestaurantModel: RestaurantModel = RestaurantModelImpl

    override fun initPresenter(view: MainView) {
        mView = view
        onUriReady()
    }

    override fun onUriReady() {
        mRestaurantModel.getRestaurants(
            onSuccess = {mView?.showRestaurants(it)},
            onFailure = {mView?.showError(it)}
        )
    }
}