package com.example.pr1k.Data.Weather.Sql

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Weather(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val town: String,
    val temp: Double
)