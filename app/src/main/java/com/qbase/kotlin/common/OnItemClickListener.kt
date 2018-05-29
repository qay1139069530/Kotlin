package com.qbase.kotlin.common

import com.qbase.kotlin.bean.weather.zipcode.Forecast

interface OnItemClickListener {

    operator fun invoke(forecast: Forecast)

}