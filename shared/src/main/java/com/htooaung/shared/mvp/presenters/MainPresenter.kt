package com.htooaung.shared.mvp.presenters

import com.htooaung.shared.mvp.views.MainView

interface MainPresenter {
    fun initPresenter(view: MainView)
    fun onUriReady()
}