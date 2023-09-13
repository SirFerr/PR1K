package com.example.pr1k.UI.View.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pr1k.Data.Product.Sql.Product
import com.example.pr1k.databinding.ProductRowBinding

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    private lateinit var binding: ProductRowBinding
    private var productList = emptyList<Product>()

    class MyViewHolder(val binding: ProductRowBinding) : RecyclerView.ViewHolder(binding.root)

    fun setData(products: List<Product>) {
        this.productList = products
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        binding = ProductRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        binding.idTxt.text = currentItem.id.toString()
        binding.nameTxt.text = currentItem.title
    }
}