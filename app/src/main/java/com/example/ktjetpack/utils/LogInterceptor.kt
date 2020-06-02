package com.example.ktjetpack.utils

import android.util.Log
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody


class LogInterceptor : Interceptor {
    private val TAG:String="LogInterceptor"
    override fun intercept(chain: Interceptor.Chain): Response {
        var request=chain.request()
        var method=request.method()
        if (method.equals("POST")){
            var sb=StringBuffer()
            if (request.body() is FormBody){
                var body=request.body() as FormBody?
                for (i in 0 until body!!.size()){
                    sb.append(body.encodedName(i)+"="+body.encodedValue(i)+",")
                }
                sb.delete(sb.length-1,sb.length)
                Log.i(TAG, "RequestParams:{$sb}")
            }
        }
        var response=chain.proceed(request)
        var mediaType= response.body()?.contentType()
        Log.i(TAG, "response body:${response.body().toString()}")

        return response.newBuilder()
                .body(ResponseBody.create(mediaType,response.body().toString()))
                .build()
    }
}