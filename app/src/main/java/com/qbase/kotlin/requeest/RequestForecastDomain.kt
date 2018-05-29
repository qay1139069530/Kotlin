package com.qbase.kotlin.requeest

import com.qbase.kotlin.bean.weather.zipcode.ForecastList
import com.qbase.kotlin.domain.Command

class RequestForecastDomain(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastResult = RequestZipcode(zipCode).execute()
        return ForecastDataManager().convertFromDataModel(forecastResult)
    }
}