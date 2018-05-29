package com.qbase.kotlin.requeest

import android.util.Log
import java.net.URL

class Request(val url: String) {

    fun run(): String {
        val josnData = URL(url).readText()
        Log.d(javaClass.simpleName, josnData)
        return josnData
    }
}