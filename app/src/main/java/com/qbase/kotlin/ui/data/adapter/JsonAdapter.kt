package com.qbase.kotlin.ui.data.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.qbase.kotlin.R
import com.qbase.kotlin.bean.weather.zipcode.ForecastList
import org.jetbrains.anko.padding

class JsonAdapter(val forecastList: ForecastList) : RecyclerView.Adapter<JsonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = TextView(parent.context)
        //val container:ViewGroup=find(R.id.container)
        textView.padding = 10
        return ViewHolder(textView)
    }

    override fun getItemCount(): Int = forecastList.dailyForecast.size

    override fun onBindViewHolder(holder: JsonAdapter.ViewHolder, position: Int) {

        with(forecastList.dailyForecast[position]) {holder.textView.text = "$date - $description - $high/$low"

        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}