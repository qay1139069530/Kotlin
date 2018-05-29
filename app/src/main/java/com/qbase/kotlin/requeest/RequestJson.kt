package com.qbase.kotlin.requeest

import com.google.gson.Gson
import com.qbase.kotlin.bean.weather.DataEntity
import java.net.URL

class RequestJson(val url: String) {

    fun run(): DataEntity {
        val josnData = URL(url).readText()
        return Gson().fromJson(josnData, DataEntity::class.java)
    }
}