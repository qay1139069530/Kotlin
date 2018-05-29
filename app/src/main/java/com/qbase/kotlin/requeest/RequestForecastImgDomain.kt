package com.qbase.kotlin.requeest

import com.qbase.kotlin.bean.weather.zipcode.ForecastImgList
import com.qbase.kotlin.domain.Command

class RequestForecastImgDomain(val zipCode: String) : Command<ForecastImgList> {

    override fun execute(): ForecastImgList {
        val forecastResult = RequestZipcode(zipCode).execute()
        return ForecastDataMapper().convertForecastImgToDomain(forecastResult)
    }
}