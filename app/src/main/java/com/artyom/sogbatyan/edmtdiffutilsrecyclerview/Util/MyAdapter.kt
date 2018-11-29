package com.artyom.sogbatyan.edmtdiffutilsrecyclerview.Util

import android.support.v7.util.DiffUtil
import com.artyom.sogbatyan.edmtdiffutilsrecyclerview.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(private val dataSource: MutableList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(p0.context)
                .inflate(R.layout.item_layout, p0, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = dataSource.get(position)
        holder.mcounter.text = (position+1).toString()

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textView: TextView = itemView.findViewById(R.id.txt_text) as TextView
        internal var mcounter: TextView = itemView.findViewById(R.id.mcounter) as TextView



    }

    fun insertItem(newList: List<String>) {
        val diffUtilCallback = MyDiffUtilCallback(dataSource, newList)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffUtilCallback)

        dataSource.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun updateItem(newList: List<String>) {
        val diffUtilCallback = MyDiffUtilCallback(dataSource, newList)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffUtilCallback)

        dataSource.clear()
        dataSource.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}