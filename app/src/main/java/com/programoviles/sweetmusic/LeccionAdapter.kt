package com.programoviles.sweetmusic

import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LeccionAdapter(private val myDataSet: ArrayList<Any>): RecyclerView.Adapter<LeccionAdapter.MyViewHolder<*>>(){
    private var adapterDataList = mutableListOf<Any>()

    companion object {
        private const val PrimaryColor = "#6200EE"
        private const val DarkPrimaryColor = "#3700B3"
        private const val TYPE_TEXTVIEW = 0
        private const val TYPE_IMAGEVIEW = 1
        private const val TYPE_AUDIO = 2
    }

    inner class TextViewHolder(itemView: View): MyViewHolder<TextView>(itemView){
        override fun bind(item: TextView) {
            item.text = myDataSet[adapterPosition] as String
            if(item.text.contains("*")){
                item.text = (item.text as String).replace("*", "")
                item.textSize = 24F
                item.setTextColor(Color.parseColor(PrimaryColor))
                item.setTypeface(null, Typeface.BOLD)
                Log.d("Adapter TitleTextView", item.text as String)
            } else if(item.text.contains('`')){
                item.text = (item.text as String).replace("`", "")
                item.textSize = 20F
                item.setTextColor(Color.parseColor("#f71d38"))
                item.setTypeface(null, Typeface.BOLD)
            } else {
                item.textSize = 15F
                Log.d("Adapter adapterDataSet", adapterDataList.toString())
            }
            Log.d("Adapter TextViewHolder", "Added TextView")
            Log.d("Adapter adapterposition", adapterPosition.toString())
        }
    }

    inner class ImageViewHolder(itemView: View): MyViewHolder<ImageView>(itemView){
        override fun bind(item: ImageView) {
            item.setImageResource(myDataSet[adapterPosition] as Int)
            item.minimumHeight = 400
            item.minimumWidth = 400
            Log.d("Adapter ImageViewHolder", "Added Imageview")
            Log.d("Adapter adapterposition", adapterPosition.toString())

        }
    }

    abstract class MyViewHolder<T>(lessonItemView: View) : RecyclerView.ViewHolder(lessonItemView) {
        abstract fun bind(item: T)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder<*> {
        Log.d("Adapter myDataSet", myDataSet.toString())
        return when(viewType){
            TYPE_TEXTVIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.textview, parent, false)
//                adapterDataList.add(view)
                Log.d("Adapter adapterDataSet", adapterDataList.toString())
                TextViewHolder(view)
            }
            TYPE_IMAGEVIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.imageview, parent, false)
//                adapterDataList.add(view)
                Log.d("Adapter adapterDataSet", adapterDataList.toString())
                ImageViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val comparable = myDataSet[position]
        return when(comparable){
            is String -> {
                TYPE_TEXTVIEW
            }
            is Int -> TYPE_IMAGEVIEW
            is Boolean -> TYPE_AUDIO
            else -> throw java.lang.IllegalArgumentException("Invalid type of data " + position)
        }
    }

    override fun getItemCount() = myDataSet.size

    override fun onBindViewHolder(holder: MyViewHolder<*>, position: Int) {
        adapterDataList.add(holder.itemView)
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