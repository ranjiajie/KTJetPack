package com.example.ktjetpack.utils

import androidx.lifecycle.LiveData
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitUtils private  constructor(){
    var CONNECT_TIME: Long = 15 //设置请求超时时间
    var READ_TIME: Long = 15 //设置读取超时时间
    var WRITE_TIME: Long = 15 //设置写入超时时间
    var BASE_URL = "https://api.gushi.ci/"
    private var retrofit: Retrofit

    init {
       var  client= OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIME, TimeUnit.SECONDS)
            .readTimeout(READ_TIME, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIME,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(LogInterceptor());
        retrofit=Retrofit.Builder()
            .client(client.build())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//与rxjava关联  用jetpack 的livedata就不用它了
            .build()
    }
    private object Instance {
        val INSTANCE = RetrofitUtils()
    }
    /**
     * 静态内部类单例模式
     *
     * @return
     */
    fun getInstance(): RetrofitUtils{
        return Instance.INSTANCE
    }

    fun <T> getRetrofitString(clzss:Class<T>):T{
        return retrofit.create(clzss)
    }


}