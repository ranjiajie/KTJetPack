package com.example.ktjetpack.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ktjetpack.model.NewTextBean
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiUrl {

    @POST("LookUp")
    @FormUrlEncoded
    fun getNewText(@Field("key") key:String):LiveData<NewTextBean>


}