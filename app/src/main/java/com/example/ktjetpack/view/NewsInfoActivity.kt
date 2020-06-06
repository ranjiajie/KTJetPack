package com.example.ktjetpack.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.ktjetpack.R
import com.example.ktjetpack.databinding.ActivityNewsinfoBinding
import kotlinx.android.synthetic.main.activity_newsinfo.*

class NewsInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewsinfoBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_newsinfo)
            binding.setLifecycleOwner(this)
            val string= intent.getStringExtra("newsname")
            text.setText(string)


    }

}