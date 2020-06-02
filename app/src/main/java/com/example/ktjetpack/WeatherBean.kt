package com.example.ktjetpack

data class WeatherBean (val ret:String,var data:DataBean) {
    data class DataBean(var err_code: String, var err_msg: String,var cloudchart:CloudChartBean){
        data class CloudChartBean(var title: String,var pic: String)
    }
}

