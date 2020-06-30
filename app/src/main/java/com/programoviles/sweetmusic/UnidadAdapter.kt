package com.programoviles.sweetmusic

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UnidadAdapter(private val myDataSet: Array<String>) : RecyclerView.Adapter<UnidadAdapter.MyViewHolder>(){

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.textview, parent, false) as TextView
        textView.textSize = 20F
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myDataSet[position]
    }

    override fun getItemCount() = myDataSet.size

}