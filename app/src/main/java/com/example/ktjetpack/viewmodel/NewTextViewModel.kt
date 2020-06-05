package com.example.ktjetpack.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ktjetpack.model.JokeBean
import com.example.ktjetpack.model.NewTextBean
import com.example.ktjetpack.utils.ApiUrl
import com.example.ktjetpack.utils.RetrofitUtils
import com.example.ktjetpack.utils.RetrofitUtils.Companion as RetrofitUtils1

class NewTextViewModel : ViewModel() {

    var data = MutableLiveData<NewTextBean>()

    /**
     *  获取数据
     */
    fun postNewText() {
        RetrofitUtils1.instance.getRetrofitString(ApiUrl::class.java)
            .getNewText("2a82b52d97ed49ca93efaec9965de9b8").observeForever {
            data.postValue(it)
        }
    }

    fun getNewText(): MutableLiveData<NewTextBean> {
        return data
    }


}


