package com.qbase.kotlin.requeest

import com.qbase.kotlin.bean.weather.zipcode.Forecast
import com.qbase.kotlin.bean.weather.zipcode.ForecastImgList
import com.qbase.kotlin.bean.weather.zipcode.ForecastResult
import java.text.DateFormat
import java.util.*

import com.qbase.kotlin.bean.weather.zipcode.ForecastImg as ModelForecast

public class ForecastDataMapper {

    public fun convertForecastImgToDomain(forecast: ForecastResult): ForecastImgList {

        return ForecastImgList(forecast.city.name, forecast.city.country, convertForecastImgListToDomain(forecast.list))
    }


    private fun convertForecastImgListToDomain(list: List<Forecast>): List<com.qbase.kotlin.bean.weather.zipcode.ForecastImg> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {

        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }


    private fun generateIconUrl(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"


    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}