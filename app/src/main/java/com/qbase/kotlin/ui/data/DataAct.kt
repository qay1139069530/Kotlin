package com.qbase.kotlin.ui.data

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.qbase.kotlin.R
import com.qbase.kotlin.bean.DataBean
import kotlinx.android.synthetic.main.act_data.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.uiThread
import java.util.*

/**数据类操作*/
class DataAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_data)

        val f1 = DataBean(Date(), 20.5f, " 天气 ")


        datatext.text = f1.toString()

        copy.onClick {
            doAsync {
                val f2 = f1.copy(temperature = 30f)
                uiThread {
                    copydata.text = f2.toString()
                }
            }
        }

        component.onClick {

            doAsync {

                val (data, temperature, detials) = f1

                uiThread {

                    componentdata.text = data.toString() + " --  " + temperature + " --  " + detials
                }


            }
        }


    }
}