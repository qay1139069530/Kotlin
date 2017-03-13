package com.kotlin.kotlinapplication

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kotlin.kotlinapplication.bean.Children
import kotlinx.android.synthetic.main.act_view.*
import org.jetbrains.anko.textColor

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_view)
        message.text = "Hello Kotlin I want to study it"

        var a = add(10, 5)

        add.text = a?.toString()

        var b = reduce(10, 5)

        reduce.text = b?.toString()
        reduce.textColor = Color.RED


        var person = Children("text click", 6)

        message.setOnClickListener {
            toast(person.name + person.age, Toast.LENGTH_LONG)
        }
    }


    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun reduce(x: Int, y: Int): Int = x - y

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

//    fun toast(message: String, tag: String = javaClass<MainActivity>().getSimpleName(), length: Int = Toast.LENGTH_SHORT) {
//        Toast.makeText(this, "[$className]$message", length).show()
//    }
}
