package com.example.ktjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ktjetpack.model.NewsInfoBean
import com.example.ktjetpack.model.NewsTextBean
import com.example.ktjetpack.utils.ApiUrl
import com.example.ktjetpack.utils.RetrofitUtils

class NewsInfoViewModel : ViewModel() {

    var data = MutableLiveData<NewsInfoBean>()

    /**
     *  获取数据
     */
    fun postNewsInfo(string: String) {
        RetrofitUtils.instance.getRetrofitString(ApiUrl::class.java)
            .getNewsInfo("2a82b52d97ed49ca93efaec9965de9b8",string,"JSON",true).observeForever {
            data.postValue(it)
        }
    }
    fun getNewsInfo(): MutableLiveData<NewsInfoBean> {
        return data
    }

}


