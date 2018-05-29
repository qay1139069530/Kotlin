package com.qbase.kotlin.bean.weather

data class City(val city: String, val aqi: Int, val ganmao: String, val wendu: String, val yesterday: Yesterday, val forecast: List<Weather>) {}