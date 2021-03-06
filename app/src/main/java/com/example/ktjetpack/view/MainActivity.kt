package com.example.ktjetpack.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktjetpack.R
import com.example.ktjetpack.databinding.ActivityMainBinding
import com.example.ktjetpack.utils.MyLifecycleObserver
import com.example.ktjetpack.view.adapter.ItemOnClick
import com.example.ktjetpack.view.adapter.NewsTextAdapter
import com.example.ktjetpack.viewmodel.NewsTextViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mAdapter:NewsTextAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(MyLifecycleObserver())


        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        val newsTextViewModel = ViewModelProvider(this).get(NewsTextViewModel::class.java)
        newsTextViewModel.postNewText()
        recyclerview.layoutManager = LinearLayoutManager(this)
        newsTextViewModel.getNewText().observe(this, Observer {
            mAdapter= NewsTextAdapter(it.result!!)
            binding.recyclerview.adapter = mAdapter
            mAdapter?.setOnClick(object :ItemOnClick{
                override fun onClicked(veiw: View, string: String) {
                    startActivity(Intent(this@MainActivity,NewsInfoActivity::class.java).putExtra("newsname",string))
                }
            })
        })
    }

}
