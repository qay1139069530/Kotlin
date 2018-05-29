package com.qbase.kotlin.ui.recycler.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.padding

class RecyclerAdapter(val items: List<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = TextView(parent.context)
        textView.padding = 10
        return ViewHolder(textView)
    }


    fun ViewGroup.get(position: Int)=getChildAt(position)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]

//        with(items) {
//            holder.textView.text = this[position]
//        }
//        with(items[position]) {
//            holder.textView.text = this
//        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}