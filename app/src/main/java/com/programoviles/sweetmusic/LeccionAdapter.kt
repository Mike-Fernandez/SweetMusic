package com.programoviles.sweetmusic

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LeccionAdapter(private val myDataSet: ArrayList<Any>): RecyclerView.Adapter<LeccionAdapter.MyViewHolder<*>>(){
    private var textViewNumber: Int = 0
    private var imageViewNumber: Int = 0
    private var audioNumber: Int = 0
    private var lessonElementNumber: Int = 0
//    private var adapterDataList = mutableListOf<Any>(lessonTitle)
    private var adapterDataList = mutableListOf<Any>()

    init {
    }

    companion object {
        private const val TYPE_TEXTVIEW = 0
        private const val TYPE_IMAGEVIEW = 1
        private const val TYPE_AUDIO = 2
    }

    inner class TextViewHolder(itemView: View): MyViewHolder<TextView>(itemView){
        override fun bind(item: TextView) {
            item.text = myDataSet[adapterPosition] as String
            Log.d("RecyclerViewLesson", "Added TextView")
        }
    }

    inner class ImageViewHolder(itemView: View): MyViewHolder<ImageView>(itemView){
        override fun bind(item: ImageView) {
            item.setImageResource(myDataSet[adapterPosition] as Int)
//            myDataSet.images?.get(imageViewNumber)?.let { item.setImageResource(it) }
            Log.d("RecyclerViewLesson", "Added ImageView")
//            adapterDataList.add(item)
        }
    }

    abstract class MyViewHolder<T>(lessonItemView: View) : RecyclerView.ViewHolder(lessonItemView) {
        abstract fun bind(item: T)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder<*> {
        return when(viewType){
            TYPE_TEXTVIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.textview, parent, false)
                adapterDataList.add(view)
                Log.d("Adapter myDataSet", myDataSet.toString())
                Log.d("Adapter adapterDataSet", adapterDataList.toString())
                TextViewHolder(view)
            }
            TYPE_IMAGEVIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.imageview, parent, false)
                adapterDataList.add(view)
                ImageViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val comparable = myDataSet[position]
        return when(comparable){
            is String -> TYPE_TEXTVIEW
            is Int -> TYPE_IMAGEVIEW
            is Boolean -> TYPE_AUDIO
            else -> throw java.lang.IllegalArgumentException("Invalid type of data " + position)
        }
    }

    override fun getItemCount() = myDataSet.size

    override fun onBindViewHolder(holder: MyViewHolder<*>, position: Int) {
        val element = adapterDataList[position]
        when(holder){
            is TextViewHolder -> {

                holder.bind(element as TextView)
            }
            is ImageViewHolder -> holder.bind(element as ImageView)
            else -> throw java.lang.IllegalArgumentException()
        }
    }

}