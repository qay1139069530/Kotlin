package com.qbase.kotlin.ui.test

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.qbase.kotlin.R
import com.qbase.kotlin.bean.Person
import com.qbase.kotlin.requeest.Request
import kotlinx.android.synthetic.main.act_test.*
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.uiThread
import org.jetbrains.anko.verticalLayout

class TestAct : AppCompatActivity() {

    val a: Int = 7
    val b: Double = a.toDouble()

    val c: Char = 'c'
    val d: Int = c.toInt()


    val _this: Context = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_test)


        val person = Person("zhangsan", 15)
        person.address = "DIZHI"
        val address = person.address

        text.text = "测试" + add(5, 10) + address
        text.onClick {
            longToast("点击测试")
        }


        //一下三种方式等同
        //val textTextView = TextView(this)
        //val textTextView = TextView(this@TestAct)
        //val textTextView = TextView(_this)


        val list = listOf(7, 2, 3, 4, 5, 6)
        val a = list.maxBy { it<5 }//a : 2 返回最大符合函数的值，比对的结果：0，1，1，1，0，0，所以取值第一个最大的 1值，即列表第二个值
        val c = list.maxBy { it>3 }//c : 3 返回最大符合函数的值，比对的结果：1，0，0，1，1，1，所以取值第一个最大的 0值，即列表第1个值
        val b = list.minBy { it<5 }//b : 7 返回最大符合函数的值，比对的结果：0，1，1，1，0，0，所以取值第一个最大的 0值，即列表第1个值
    }

    fun add(a: Int, b: Int) = a + b


}
