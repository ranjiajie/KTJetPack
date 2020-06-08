package com.example.ktjetpack.utils

import androidx.lifecycle.LiveData
import com.example.ktjetpack.model.NewsInfoBean
import com.example.ktjetpack.model.NewsTextBean
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiUrl {

    @POST("LookUp")
    @FormUrlEncoded
    fun getNewsText(@Field("key") key:String):LiveData<NewsTextBean>


    @POST("Query")
    @FormUrlEncoded
    fun getNewsInfo(@Field("key") key:String,@Field("keyword") keyword:String,@Field("dtype") dtype:String,@Field("format") format:Boolean):LiveData<NewsInfoBean>
}