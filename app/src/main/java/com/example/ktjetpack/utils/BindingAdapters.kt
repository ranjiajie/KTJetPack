package com.example.ktjetpack.utils

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ktjetpack.R


object BindingAdapters{
    @BindingAdapter("itemcolor")
    @JvmStatic
    fun itemcolor(textview: TextView,string:String) {
        if (string.length>7)
        textview.setTextColor(Color.BLUE)
        if (string.length<=5)
            textview.setTextColor(Color.RED)
    }


    @BindingAdapter("imgUrl")
    @JvmStatic
    fun imgUrl(view: ImageView,imageUrl:String?) {
        val options = RequestOptions()
            .fitCenter()
            .placeholder(R.drawable.ic_imgloading)
            .error(R.drawable.ic_imgfail)
            .dontAnimate()

        Glide.with(view)
            .load(imageUrl)
            .apply(options)
            .into(view)
    }
}