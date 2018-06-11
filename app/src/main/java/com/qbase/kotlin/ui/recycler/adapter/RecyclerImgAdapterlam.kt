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
import kotlinx.android.synthetic.main.ad_recyclericon.view.*
import org.jetbrains.anko.find

class RecyclerImgAdapterlam(val weekForecast: ForecastImgList, val itemClick: (ForecastImg)->Unit) : RecyclerView.Adapter<RecyclerImgAdapterlam.ViewHolder>() {


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

    class ViewHolder(view: View, val itemClick: (ForecastImg)->Unit) : RecyclerView.ViewHolder(view) {

        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            //itemView.date
            //可替换一下代码
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)

        }


        fun bindForecast(forecast: ForecastImg) {
            with(forecast) {
                Picasso.get().load(iconUrl).fit().tag(itemView.context).into(iconView)
                itemView.date.text= date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick.invoke(forecast) }



            }
        }
    }

}