package com.example.ktjetpack.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ktjetpack.R
import com.example.ktjetpack.databinding.ItemNewtextBinding


class NewsTextAdapter(private val mlist: List<String>) :
    RecyclerView.Adapter<NewsTextAdapter.MyViewHolder>() {

    var itemOnClick: ItemOnClick? =null
    fun setOnClick(itemOnClick: ItemOnClick){
        this.itemOnClick=itemOnClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_newtext,
            parent,
            false
        )
    )
    override fun getItemCount() = mlist.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.text = mlist[position]
        holder.binding.itemTextview.setOnClickListener {
            Log.i("MainActivity","position "+position)
            itemOnClick?.onClicked(it,mlist[position])
        }
    }
    class MyViewHolder(val binding: ItemNewtextBinding) : RecyclerView.ViewHolder(binding.root)



}