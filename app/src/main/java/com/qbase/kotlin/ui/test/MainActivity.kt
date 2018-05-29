package com.qbase.kotlin.ui.test

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.act_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        adapter.setOnClickListener {
            startActivity(Intent(MainActivity@ this, TianqiActivity::class.java))
        }

        view.setOnClickListener {
            startActivity(Intent(MainActivity@ this, ViewActivity::class.java))
        }

        myview.setOnClickListener {
            startActivity(Intent(MainActivity@ this, MyViewActivity::class.java))
        }

        value.setOnClickListener {
            startActivity(Intent(MainActivity@ this, ValueActivity::class.java))
        }
    }

}
