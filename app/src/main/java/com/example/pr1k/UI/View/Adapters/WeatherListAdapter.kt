package com.example.pr1k.UI.View.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pr1k.Data.Weather.Sql.Weather
import com.example.pr1k.databinding.WeatherRowBinding

class WeatherListAdapter : RecyclerView.Adapter<WeatherListAdapter.MyViewHolder>() {

    private lateinit var binding: WeatherRowBinding
    private var weatherList = emptyList<Weather>()

    class MyViewHolder(val binding: WeatherRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        binding = WeatherRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = weatherList[position]
        binding.townTxt.text = currentItem.town
        binding.tempTxt.text = currentItem.temp.toString()
    }
}