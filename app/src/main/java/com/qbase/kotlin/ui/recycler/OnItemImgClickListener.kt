package com.qbase.kotlin.ui.recycler

import com.qbase.kotlin.bean.weather.zipcode.ForecastImg

public interface OnItemImgClickListener {

    operator fun invoke(forecast: ForecastImg)

}