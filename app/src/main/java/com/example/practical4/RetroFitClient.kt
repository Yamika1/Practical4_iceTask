package com.example.practical4

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitClient {

    private val retroFit : Retrofit =
        Retrofit.Builder().baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val weatherService : IOpenWeather =
        retroFit.create(IOpenWeather::class.java)

}