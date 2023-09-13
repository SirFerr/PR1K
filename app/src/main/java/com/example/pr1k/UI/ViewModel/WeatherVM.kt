package com.example.pr1k.UI.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pr1k.Data.Weather.Sql.Weather
import com.example.pr1k.Data.Weather.Sql.WeatherDatabase
import com.example.pr1k.Data.Weather.Sql.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherVM(application: Application) : AndroidViewModel(application) {

    private val repository: WeatherRepository
    val getAllData: LiveData<List<Weather>>

    init {
        val weatherDao = WeatherDatabase.getDatabase(application).weatherDao()
        repository = WeatherRepository(weatherDao)
        getAllData = repository.getAllData
    }

    fun addItem(weather: Weather) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(weather)
        }
    }
}