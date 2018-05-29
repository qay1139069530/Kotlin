package com.qbase.kotlin.bean.weather.zipcode

data class City(val id: Long, val name: String, val coord: Coordinates,
                val country: String, val population: Int)