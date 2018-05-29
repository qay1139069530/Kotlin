package com.qbase.kotlin.ui.request

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.qbase.kotlin.R
import com.qbase.kotlin.requeest.Request
import kotlinx.android.synthetic.main.act_request.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.uiThread

/**网络请求类操作*/
class RequestAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_request)

        request.onClick {
            doAsync {
                val data = Request("http://wthrcdn.etouch.cn/weather_mini?city=%E8%8B%8F%E5%B7%9E").run()
                uiThread {
                    requestdata.text = data
                }
            }
        }
    }


}