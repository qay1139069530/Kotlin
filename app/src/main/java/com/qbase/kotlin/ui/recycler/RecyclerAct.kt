package com.qbase.kotlin.ui.recycler

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.qbase.kotlin.R
import com.qbase.kotlin.ui.data.adapter.JsonAdapter
import com.qbase.kotlin.ui.recycler.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.act_josn.*

/**列表操作*/
class RecyclerAct : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_recycler)


        onRecyclerView()
    }

    fun onRecyclerView() {
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = RecyclerAdapter(items)

        //以上等同于
//
//        mRecyclerView.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = RecyclerAdapter(items)
//        }
//
//        //以上等同于
//
//        with(mRecyclerView) {
//            layoutManager = LinearLayoutManager(context)
//            adapter = RecyclerAdapter(items)
//        }


//        //延迟
//        val init: RecyclerView = Lazy(LazyThreadSafetyMode.SYNCHRONIZED){
//            mRecyclerView.apply {
//                layoutManager = LinearLayoutManager(context)
//                adapter = RecyclerAdapter(items)
//            }
//        }
//
//        //使用这个lazy<TextView>对象
//        init.adapter = RecyclerAdapter(items)



    }

}
