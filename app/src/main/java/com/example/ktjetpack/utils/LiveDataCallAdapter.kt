package com.example.ktjetpack.utils

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.ktjetpack.R
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.math.log

class LiveDataCallAdapter<R>(private val responseType: Type) : CallAdapter<R, LiveData<R>> {
    override fun responseType() = responseType
    override fun adapt(call: Call<R>): LiveData<R> {
        return object : LiveData<R>() {
            private var started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            postValue(response.body())
                        }

                        override fun onFailure(call: Call<R>, throwable: Throwable) {
                            Log.d("OkHttp",throwable.message+"")
                            postValue(null)
                        }
                    })
                }
            }
        }
    }
}