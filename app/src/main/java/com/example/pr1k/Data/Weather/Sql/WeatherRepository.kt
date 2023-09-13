package com.example.pr1k.Data.Weather.Sql

import androidx.lifecycle.LiveData

class WeatherRepository(private val weatherDao: WeatherDao) {

    var getAllData: LiveData<List<Weather>> = weatherDao.getAll()
    suspend fun addItem(weather: Weather) {
        weatherDao.insert(weather)
    }

}