package com.example.ktjetpack.utils

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapters{
    @BindingAdapter("itemcolor")
    @JvmStatic
    fun itemcolor(textview: TextView,string:String) {
        if (string.length>7)
        textview.setTextColor(Color.BLUE)
        if (string.length<=5)
            textview.setTextColor(Color.RED)
    }
}