package com.example.ktjetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ktjetpack.WeatherBean
import kotlin.reflect.KProperty

class WeatherViewModel :ViewModel() {

     val weatherBean: MutableLiveData<WeatherBean> =MutableLiveData()

    fun getUsers(): LiveData<WeatherBean> {
        return weatherBean
    }

    private fun loadWeatherBean() {
        // Do an asynchronous operation to fetch users.
    }
}


