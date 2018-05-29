package com.qbase.kotlin.bean.weather.zipcode

data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<ForecastT>)