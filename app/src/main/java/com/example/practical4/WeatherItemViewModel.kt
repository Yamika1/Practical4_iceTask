package com.example.practical4

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherItemViewModel  : ViewModel(){

    private val _forecast = MutableLiveData<WeatherItem>()
    val forecast : LiveData<WeatherItem> = _forecast

    fun getForecast(description: String, temp: String, dt_text : String ){
        viewModelScope.launch {
            try{
                val weatherData = RetroFitClient.weatherService.getForcast(
                    description,
                    temp,
                    dt_text   )
                _forecast.value = weatherData
            }catch(e: Exception){
                Log.e("WEATHER", e.toString())
            }
        }
    }
}