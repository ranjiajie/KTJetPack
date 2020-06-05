package com.example.ktjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ktjetpack.databinding.ActivityMainBinding
import com.example.ktjetpack.model.JokeBean
import com.example.ktjetpack.viewmodel.NewTextViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //    2a82b52d97ed49ca93efaec9965de9b8
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        val newTextViewModel = ViewModelProvider(this).get(NewTextViewModel::class.java)
        newTextViewModel.postNewText()
        newTextViewModel.getNewText().observe(this, Observer {
            binding.newtextbean=it
        })
    }

}
