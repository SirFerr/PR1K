package com.example.pr1k.Data.Product.Remote

import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getAllProduct(): Products
}