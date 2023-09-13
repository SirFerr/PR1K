package com.example.pr1k.Data.Product.Sql

import androidx.lifecycle.LiveData

class ProductRepository(private val productDao: ProductDao) {

    val getAllData: LiveData<List<Product>> = productDao.getAll()

    suspend fun addProduct(product: Product) {
        productDao.insert(product)
    }

    suspend fun addAllProduct(products: List<Product>) {
        productDao.insertAll(products)
    }

}