package com.example.ktjetpack.utils

import androidx.lifecycle.LiveData
import com.example.ktjetpack.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitUtils private  constructor(){
    var CONNECT_TIME: Long = 15 //设置请求超时时间
    var READ_TIME: Long = 15 //设置读取超时时间
    var WRITE_TIME: Long = 15 //设置写入超时时间
    var BASE_URL = "http://api.avatardata.cn/ActNews/"
    private var retrofit: Retrofit
    init {
       val  client= OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIME, TimeUnit.SECONDS)
            .readTimeout(READ_TIME, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIME,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(loggingInterceptor)
        }
        retrofit=Retrofit.Builder()
            .client(client.build())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//与rxjava关联  用jetpack 的livedata就不用它了
            .build()

    }
    //静态内部类单例
    private object RetrofitUtilsHolder {
        val INSTANCE = RetrofitUtils()
    }
    companion object {
        val instance = RetrofitUtilsHolder.INSTANCE
    }


    fun <T> getRetrofitString(clzss:Class<T>):T{
        return retrofit.create(clzss)
    }


}