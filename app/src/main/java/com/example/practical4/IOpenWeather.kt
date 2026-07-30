package com.example.practical4

import retrofit2.http.GET
import retrofit2.http.Query


interface IOpenWeather {
    @GET("data/2.5/forecast")
    suspend fun getForcast(
        @Query("q") description: String,
        @Query("temp") temp: String,
        @Query("dt_text") dt_text: String
    ) : WeatherItem


}