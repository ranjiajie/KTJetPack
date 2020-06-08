package com.example.ktjetpack.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.ktjetpack.BR


class NewsTextBean (): BaseObservable() {
    var error_code:String=""
    @get:Bindable
    var reason: String=""
        set(value) {
            field=value
            notifyPropertyChanged(BR.reason)
        }
    @get:Bindable
    var result:List<String>?=null
        set(value) {
            field=value
            notifyPropertyChanged(BR.result)
        }

}