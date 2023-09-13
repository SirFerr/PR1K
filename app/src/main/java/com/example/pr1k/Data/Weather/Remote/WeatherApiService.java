package com.example.pr1k.Data.Weather.Remote;

import retrofit2.http.GET;
import retrofit2.http.Query;

public class WeatherApiService {

    @GET("weather") // Replace with the actual API endpoint
    suspend fun getWeatherData(
            @Query("city")city: String,
            @Query("apiKey")apiKey: String
    ): WeatherResponse
}
