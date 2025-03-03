package com.htooaung.buildConfig.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.htooaung.buildConfig.R
import com.htooaung.buildConfig.adapters.RestaurantListAdapter
import com.htooaung.buildConfig.databinding.ActivityMainBinding
import com.htooaung.shared.data.vos.RestaurantVO
import com.htooaung.shared.mvp.presenters.MainPresenter
import com.htooaung.shared.mvp.presenters.MainPresenterImpl
import com.htooaung.shared.mvp.views.MainView

import com.htooaung.shared.showSnackBar

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var mPresenter: MainPresenter
    private lateinit var binding: ActivityMainBinding
    private var mAdapter: RestaurantListAdapter = RestaurantListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()
//        setUpToolBar()
        setUpRecyclerView()

    }

//    private fun setUpToolBar(){
//        setSupportActionBar(binding.toolBar)
//        supportActionBar?.title = getString(R.string.app_name)
//    }
    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        binding.rvRestaurantList.adapter = mAdapter
        binding.rvRestaurantList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun showRestaurants(restaurants: List<RestaurantVO>) {
        mAdapter.setData(restaurants)
    }

    override fun showError(error: String) {
        showSnackBar(error)
    }
}