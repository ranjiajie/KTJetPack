package com.example.ktjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ktjetpack.model.NewsTextBean
import com.example.ktjetpack.utils.ApiUrl
import com.example.ktjetpack.utils.RetrofitUtils.Companion as RetrofitUtils1

class NewsTextViewModel : ViewModel() {

    var data = MutableLiveData<NewsTextBean>()

    /**
     *  获取数据
     */
    fun postNewText() {
        RetrofitUtils1.instance.getRetrofitString(ApiUrl::class.java)
            .getNewsText("2a82b52d97ed49ca93efaec9965de9b8").observeForever {
            data.postValue(it)
        }
    }

    fun getNewText(): MutableLiveData<NewsTextBean> {
        return data
    }


}


