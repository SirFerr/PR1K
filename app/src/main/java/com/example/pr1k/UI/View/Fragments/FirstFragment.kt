package com.example.pr1k.UI.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pr1k.Data.Product.Remote.ProductApi
import com.example.pr1k.R
import com.example.pr1k.UI.View.Adapters.ProductListAdapter
import com.example.pr1k.UI.ViewModel.ProductVM
import com.example.pr1k.databinding.FragmentFirstBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var mProductVM: ProductVM;


    override fun onResume() {
        super.onResume()

    }

    //    fun getAllData(): LiveData<List<Product>> {
//
//
//        val productApi= retrofit.create(ProductApi::class.java)
//        CoroutineScope(Dispatchers.IO).launch {
//            val products = productApi.getAllProduct()
//
//        }
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        mProductVM = ViewModelProvider(this).get(ProductVM::class.java)
        val retrofit = Retrofit.Builder().baseUrl("https://dummyjson.com").addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val productApi = retrofit.create(ProductApi::class.java)
        CoroutineScope(Dispatchers.IO).launch {

            val products = productApi.getAllProduct()

            mProductVM.addAllItem(products.products)


        }

        val adapter = ProductListAdapter()
        binding.resyclerView.layoutManager = LinearLayoutManager(requireContext())
        mProductVM.getAllData.observe(viewLifecycleOwner) { product ->
            adapter.setData(product)
        }
        binding.resyclerView.adapter = adapter

        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_addFragment)
        }

        return binding.root
    }

}