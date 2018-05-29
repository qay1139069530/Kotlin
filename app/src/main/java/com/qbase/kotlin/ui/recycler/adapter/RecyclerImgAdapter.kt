package com.qbase.kotlin.ui.recycler.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.qbase.kotlin.R
import com.qbase.kotlin.bean.weather.zipcode.ForecastImg
import com.qbase.kotlin.bean.weather.zipcode.ForecastImgList
import com.qbase.kotlin.ui.recycler.OnItemImgClickListener
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class RecyclerImgAdapter(val weekForecast: ForecastImgList, val itemClick: OnItemImgClickListener) : RecyclerView.Adapter<RecyclerImgAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.ad_recyclericon, parent, false)
        return ViewHolder(view, itemClick)
    }


    fun ViewGroup.get(position: Int) = getChildAt(position)

    override fun getItemCount(): Int = weekForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    class ViewHolder(view: View, val itemClick: OnItemImgClickListener) : RecyclerView.ViewHolder(view) {

        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }


        fun bindForecast(forecast: ForecastImg) {
            with(forecast) {
                Picasso.get().load(iconUrl).fit().tag(itemView.context).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick.invoke(forecast) }
            }
        }
    }

}