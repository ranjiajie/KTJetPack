package com.example.ktjetpack.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ktjetpack.R
import com.example.ktjetpack.databinding.ItemNewinfoBinding
import com.example.ktjetpack.model.NewsInfoBean


class NewsInfoAdapter(private val mlist: List<NewsInfoBean.Databean>) : RecyclerView.Adapter<NewsInfoAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ItemNewinfoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),R.layout.item_newinfo,parent,false
        )
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.databean=mlist[position]
    }

    override fun getItemCount(): Int  = mlist.size



}