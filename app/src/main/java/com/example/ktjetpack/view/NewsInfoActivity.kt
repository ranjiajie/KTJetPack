package com.example.ktjetpack.view

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktjetpack.R
import com.example.ktjetpack.databinding.ActivityNewsinfoBinding
import com.example.ktjetpack.view.adapter.NewsInfoAdapter
import com.example.ktjetpack.view.adapter.NewsTextAdapter
import com.example.ktjetpack.viewmodel.NewsInfoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_newsinfo.*

class NewsInfoActivity : AppCompatActivity() {

    private var mAdapter: NewsInfoAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewsinfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_newsinfo)
            binding.setLifecycleOwner(this)
        val viewModel = ViewModelProvider(this).get(NewsInfoViewModel::class.java)
        val string= intent.getStringExtra("newsname")
        binding.query=string

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.postNewsInfo(string)
        viewModel.getNewsInfo().observe(this, Observer {
            if (it.result==null){
                Toast.makeText(this,"未查询到详情",Toast.LENGTH_SHORT).show()
                finish()
            }else{
                mAdapter= NewsInfoAdapter(it.result!!)
                binding.recyclerView.adapter=mAdapter
            }
        })




    }

}