package com.example.ktjetpack.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.ktjetpack.BR

class NewsInfoBean {
    var error_code:String=""
    var reason: String=""
    var result:List<Databean>?=null
    class Databean:BaseObservable(){
        var title: String?=""
        var content: String?=""
        var img_width: String?=""
        var full_title: String?=""
        var pdate: String?=""
        var src: String?=""
        var img_length: String?=""
        @get:Bindable
        var img: String?=""
            set(value) {
                field=value
                notifyPropertyChanged(BR.img)
            }

        @get:Bindable
        var url: String?=""
            set(value) {
                field=value
                notifyPropertyChanged(BR.url)
            }
        var pdate_src: String?=""
    }

}