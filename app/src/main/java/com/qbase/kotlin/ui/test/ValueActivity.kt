package com.kotlin.kotlinapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.kotlinapplication.bean.Person
import com.qbase.kotlin.R
import kotlinx.android.synthetic.main.act_value.*

class ValueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_value)

        //可变量
        var i: Int = 7;
        var b: Double = i.toDouble()
        var c: Char = 'c'
        var c_i: Int = c.toInt()

        var i_2 = i or i
        var i_3 = i and i

        var j = 1
        var jHex = 0x0f
        var j_d = 3.5
        var j_f = 3.5f
        var j_l = 3L

        var s_1 = "Hello World"
        var s_2 = s_1[2]

        for (s in s_1) {
            print(s)
        }

        //不可变量
        val va = 1234

        val p = P()
        p.name = "name"
        val name = p.name


        val person = Person()
        person.name = "zhangsan"
        person.sex = "nan"
        val str: String = person.name + "--" + person.sex
        text.setText(str)

    }


    class P {
        var name: String = ""
    }
}
