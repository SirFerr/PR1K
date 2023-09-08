package com.example.pr1k.UI.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pr1k.Data.Item.Item
import com.example.pr1k.databinding.CustomRowBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private lateinit var binding: CustomRowBinding;
    private var itemList = emptyList<Item>()

    class MyViewHolder(val binding: CustomRowBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        binding.idTxt.text = currentItem.id.toString()
        binding.nameTxt.text = currentItem.name.toString()
    }

    fun setData(item: List<Item>) {
        this.itemList = item
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}