package com.qbase.kotlin.ui.data

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.qbase.kotlin.R
import com.qbase.kotlin.bean.weather.zipcode.ForecastList
import com.qbase.kotlin.requeest.RequestForecastDomain
import com.qbase.kotlin.requeest.RequestJson
import com.qbase.kotlin.ui.data.adapter.JsonAdapter
import kotlinx.android.synthetic.main.act_josn.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.uiThread

class JosnAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_josn)


        request.onClick {
            doAsync {
                val data = RequestJson("http://wthrcdn.etouch.cn/weather_mini?city=%E8%8B%8F%E5%B7%9E").run()
                uiThread {
                    //josndata.text = data

                    yesterasydata.text = data.data.yesterday.toString()

                    citydata.text = data.data.city + " -- " + data.data.ganmao + " -- " + data.data.aqi + " -- " + data.data.wendu

                    weatherdata.text = data.data.forecast.toString()
                }
            }
        }


//        zipcode.onClick {
//            doAsync {
//                val data = RequestZipcode("LonDon").execute()
//                uiThread {
//                    //josndata.text = data
//
//                    weatherdata.text = data.toString()
//                }
//            }
//        }


        zipcode.onClick {
            doAsync {
                val data = RequestForecastDomain("94043").execute()
                uiThread {
                    //josndata.text = data
                    onRecyclerView(data)
                }
            }
        }

    }


    fun onRecyclerView(forecastList: ForecastList) {

        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = JsonAdapter(forecastList)
        }
    }


}