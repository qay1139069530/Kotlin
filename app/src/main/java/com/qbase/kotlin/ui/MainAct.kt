package com.qbase.kotlin.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.qbase.kotlin.R
import com.qbase.kotlin.ui.data.DataAct
import com.qbase.kotlin.ui.data.JosnAct
import com.qbase.kotlin.ui.method.MethodAct
import com.qbase.kotlin.ui.recycler.RecyclerIconAct
import com.qbase.kotlin.ui.request.RequestAct
import com.qbase.kotlin.ui.test.TestAct
import kotlinx.android.synthetic.main.act_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import kotlin.properties.Delegates

class MainAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)


        recycler.onClick {
            startActivity(Intent(this@MainAct, RecyclerIconAct::class.java))
        }

        request.onClick {
            startActivity(Intent(this@MainAct, RequestAct::class.java))
        }


        json.onClick {
            startActivity(Intent(this@MainAct, JosnAct::class.java))
        }

        data.onClick {
            startActivity(Intent(this@MainAct, DataAct::class.java))
        }

        test.onClick {
            startActivity(Intent(this@MainAct, TestAct::class.java))
        }

        method.onClick {
            startActivity(Intent(this@MainAct, MethodAct::class.java))
        }
    }
}