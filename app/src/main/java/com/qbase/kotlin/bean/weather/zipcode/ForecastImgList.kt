package com.qbase.kotlin.bean.weather.zipcode

data class ForecastImgList(val city: String, val country: String,
                        val dailyForecast:List<ForecastImg>){

    val size:Int get() = dailyForecast.size

    operator fun get(position:Int)=dailyForecast[position]
}