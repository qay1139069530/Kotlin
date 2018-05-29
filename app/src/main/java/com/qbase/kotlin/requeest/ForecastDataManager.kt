package com.qbase.kotlin.requeest

import com.qbase.kotlin.bean.weather.zipcode.Forecast
import com.qbase.kotlin.bean.weather.zipcode.ForecastList
import com.qbase.kotlin.bean.weather.zipcode.ForecastResult
import java.text.DateFormat
import java.util.*

import com.qbase.kotlin.bean.weather.zipcode.ForecastT as ModelForecast

public class ForecastDataManager {

    fun convertFromDataModel(forecastResult: ForecastResult): ForecastList {

        return ForecastList(forecastResult.city.name, forecastResult.city.country, convertForecastListToDomain(forecastResult.list))

    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }


    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}