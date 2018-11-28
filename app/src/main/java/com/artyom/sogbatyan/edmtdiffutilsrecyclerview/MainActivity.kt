package com.artyom.sogbatyan.edmtdiffutilsrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.artyom.sogbatyan.edmtdiffutilsrecyclerview.Util.MyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    internal var dataSource: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = (LinearLayoutManager(this))

        initData()

        val adapter = MyAdapter(dataSource)
        recycler_view.adapter = adapter

        btn_insert.setOnClickListener {
            val newData = ArrayList<String>()

            for (i in 0..2)
                newData.add(UUID.randomUUID().toString())
            adapter.insertItem(newData)
            recycler_view.smoothScrollToPosition(adapter.itemCount-1)
        }

        btn_update.setOnClickListener {
            val newData = ArrayList<String>()

            for (i in 0..2)
                newData.add(UUID.randomUUID().toString())
            adapter.insertItem(newData)
        }
    }

    private fun initData() {
        for (i in 0..1) {
            dataSource.add(UUID.randomUUID().toString())
        }
    }
}
