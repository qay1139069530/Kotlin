package com.qbase.kotlin.app

import android.app.Application
import kotlin.properties.Delegates

class KotlinApp : Application() {


//    companion object {
//        private var Instance: KotlinApp? = null
//        fun instance()= Instance!!
//    }

    companion object {
        var Instance : KotlinApp by Delegates.notNull()
    }



    override fun onCreate() {
        super.onCreate()
        Instance = this
    }
}