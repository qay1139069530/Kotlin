package com.qbase.kotlin.ui.test.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by dell on 2017/1/11.
 */
public class TianqiAdapter(var items: List<String>) : RecyclerView.Adapter<TianqiAdapter.ViewHolder>() {


    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.textview?.text = items[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    class ViewHolder(var textview: TextView) : RecyclerView.ViewHolder(textview)
}