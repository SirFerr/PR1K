package com.example.pr1k.UI.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pr1k.Data.Product.Sql.Product
import com.example.pr1k.Data.Product.Sql.ProductDatabase
import com.example.pr1k.Data.Product.Sql.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductVM(application: Application) : AndroidViewModel(application) {

    private val repository: ProductRepository
    val getAllData: LiveData<List<Product>>

    init {
        val productDao = ProductDatabase.getDatabase(application).productDao()
        repository = ProductRepository(productDao)
        getAllData = repository.getAllData
    }

    fun addItem(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProduct(product)
        }
    }

    suspend fun addAllItem(products: List<Product>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAllProduct(products)
        }
    }
}