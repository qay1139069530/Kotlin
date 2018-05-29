package com.qbase.kotlin.ui.recycler

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.qbase.kotlin.R
import com.qbase.kotlin.bean.weather.zipcode.ForecastImg
import com.qbase.kotlin.bean.weather.zipcode.ForecastImgList
import com.qbase.kotlin.requeest.RequestForecastImgDomain
import com.qbase.kotlin.ui.recycler.adapter.RecyclerImgAdapter
import kotlinx.android.synthetic.main.act_josn.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

/**列表操作*/
class RecyclerIconAct : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_recycler)
        initData()
    }


    fun initData(){
        doAsync {
            val data = RequestForecastImgDomain("94043").execute()

            uiThread {
                //josndata.text = data
                onRecyclerView(data)
            }
        }
    }

    fun onRecyclerView(data: ForecastImgList) {
//
        with(mRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = RecyclerImgAdapter(data,object :OnItemImgClickListener{

                override fun invoke(forecast: ForecastImg) {
                    toast(forecast.date)
                }

            })
        }


//        forecastList.adapter = ForecastListAdapter(result,
//                object : ForecastListAdapter.OnItemClickListener{
//                    override fun invoke(forecast: Forecast) {
//                        toast(forecast.date)
//                    }
//                })

    }


}
