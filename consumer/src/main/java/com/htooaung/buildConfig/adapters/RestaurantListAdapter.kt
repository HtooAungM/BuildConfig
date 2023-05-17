package com.htooaung.buildConfig.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.htooaung.buildConfig.R
import com.htooaung.buildConfig.viewholders.RestaurantViewHolder
import com.htooaung.shared.data.vos.RestaurantVO

class RestaurantListAdapter: RecyclerView.Adapter<RestaurantViewHolder>() {
    private var mData: List<RestaurantVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_restaurant,parent,false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bindData(mData[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<RestaurantVO>){
        mData = data
        notifyDataSetChanged()
    }
}