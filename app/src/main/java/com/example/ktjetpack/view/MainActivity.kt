package com.example.ktjetpack.view

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktjetpack.R
import com.example.ktjetpack.databinding.ActivityMainBinding
import com.example.ktjetpack.utils.MyLifecycleObserver
import com.example.ktjetpack.view.adapter.ItemOnClick
import com.example.ktjetpack.view.adapter.NewTextAdapter
import com.example.ktjetpack.viewmodel.NewTextViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    private var mAdapter:NewTextAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(MyLifecycleObserver())


        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        val newTextViewModel = ViewModelProvider(this).get(NewTextViewModel::class.java)
        newTextViewModel.postNewText()
        recyclerview.layoutManager = LinearLayoutManager(this)
        newTextViewModel.getNewText().observe(this, Observer {
            mAdapter= NewTextAdapter(it.result!!)
            binding.recyclerview.adapter = mAdapter
            mAdapter?.setOnClick(object :ItemOnClick{
                override fun onClicked(veiw: View, string: String) {
                    startActivity(Intent(this@MainActivity,NewsInfoActivity::class.java).putExtra("newsname",string))
                }
            })
        })
    }

}
