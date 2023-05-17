package com.htooaung.buildConfig.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.htooaung.buildConfig.databinding.ViewholderRestaurantBinding

import com.htooaung.shared.data.vos.RestaurantVO

class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private  var binding: ViewholderRestaurantBinding
    init{
        binding = ViewholderRestaurantBinding.bind(itemView)
    }
    fun bindData(data: RestaurantVO){
        Glide
            .with(itemView.context)
            .load(data.imageUrl)
            .into(binding.ivRestaurantImage)
        binding.tvRestaurantName.text = data.name
        binding.tvCategory.text = data.category
        binding.tvDeliveryPrice.text = "${data.deliveryPrice.toString()} MMK"
        binding.tvRating.text = data.rating.toString()
    }
}