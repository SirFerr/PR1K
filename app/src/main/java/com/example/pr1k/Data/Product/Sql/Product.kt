package com.example.pr1k.Data.Product.Sql

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,

    )