package com.kotlin.kotlinapplication

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.qbase.kotlin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MyViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(10)

            var name = editText()
            name.hint = "name"
            name.textSize = 18f
            name.backgroundDrawable = resources.getDrawable(R.drawable.bg_edittext)
            name.padding = dip(10)


            var password = editText()
            password.hint = "password"
            password.textSize = 18f
            password.backgroundDrawable = resources.getDrawable(R.drawable.bg_edittext)
            password.padding = dip(10)
            password.lparams(width = matchParent) {
                topMargin = dip(10)
            }


            button {
                text = "Login"
                textColor = Color.WHITE
                textSize = 20f
                backgroundDrawable = resources.getDrawable(R.drawable.bg_blue)
                onClick {
                    toast("hello ${name.text}")
                }
            }.lparams(width = matchParent) {
                topMargin = dip(30)
            }

        }
    }
}
