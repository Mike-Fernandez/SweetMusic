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

class LeccionAdapter(private val myDataSet: Leccion, val lessonTitle: TextView): RecyclerView.Adapter<LeccionAdapter.MyViewHolder<*>>(){
    private var textViewNumber: Int = 0
    private var imageViewNumber: Int = 0
    private var audioNumber: Int = 0
    private var lessonElementNumber: Int = 0
    private var adapterDataList = mutableListOf<Any>(lessonTitle)

    init {
//        adapterDataList  = mutableListOf<Any>(myDataSet.title)
    }

    companion object {
        private const val TYPE_TEXTVIEW = 0
        private const val TYPE_IMAGEVIEW = 1
        private const val TYPE_AUDIO = 2
    }

    inner class TextViewHolder(itemView: View): MyViewHolder<TextView>(itemView){
        override fun bind(item: TextView) {
            item.text = myDataSet.textBlock[textViewNumber]
            textViewNumber++
            adapterDataList.add(item)
            Log.d("RecyclerViewLesson", "Added TextView")
        }
    }

    inner class ImageViewHolder(itemView: View): MyViewHolder<ImageView>(itemView){
        override fun bind(item: ImageView) {
            item.setImageResource(myDataSet.images[imageViewNumber])
//            myDataSet.images?.get(imageViewNumber)?.let { item.setImageResource(it) }
            imageViewNumber++
            adapterDataList.add(item)
            Log.d("RecyclerViewLesson", "Added ImageView")
        }
    }

    abstract class MyViewHolder<T>(lessonItemView: View) : RecyclerView.ViewHolder(lessonItemView) {
        abstract fun bind(item: T)
    }

/*    class MyViewHolder<T>(val lessonItemView: View) : RecyclerView.ViewHolder(lessonItemView){

    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder<*> {
        return when(myDataSet.estructura[lessonElementNumber]){
            TYPE_TEXTVIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.textview, parent, false)

                TextViewHolder(view)
            }
            TYPE_IMAGEVIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.imageview, parent, false)
                ImageViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val comparable = myDataSet.estructura[position]
        return when(comparable){
            0 -> TYPE_TEXTVIEW
            1 -> TYPE_IMAGEVIEW
            2 -> TYPE_AUDIO
            else -> throw java.lang.IllegalArgumentException("Invalid type of data " + position)
        }
    }

    override fun getItemCount() = myDataSet.estructura.size

    override fun onBindViewHolder(holder: MyViewHolder<*>, position: Int) {
        val element = adapterDataList[position]
        when(holder){
            is TextViewHolder -> holder.bind(element as TextView)
            is ImageViewHolder -> holder.bind(element as ImageView)
            else -> throw java.lang.IllegalArgumentException()
        }
    }

}