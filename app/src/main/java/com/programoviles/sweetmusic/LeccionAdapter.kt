package com.programoviles.sweetmusic

import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_afinador.view.*

class LeccionAdapter (private val myDataSet: Leccion): RecyclerView.Adapter<LeccionAdapter.MyViewHolder>(){
    var imageCounter: Int = 0
    var textBlockCounter: Int = 0
    var subSectionCounter: Int = 0
    var titleShown: Boolean = false

    companion object {
        private const val PrimaryColor = "#6200EE"
        private const val DarkPrimaryColor = "#3700B3"
        private const val TYPE_TEXTVIEW = 0
        private const val TYPE_IMAGEVIEW = 1
        private const val TYPE_SUBSECTION = 2
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imageView: ImageView
        var title: TextView
        var textBlock: TextView
        var subsection: TextView

        init {
            imageView = itemView.findViewById(R.id.lessonImage)
            title = itemView.findViewById(R.id.title)
            textBlock = itemView.findViewById(R.id.texto)
            subsection = itemView.findViewById(R.id.header2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeccionAdapter.MyViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.lessoncardview, parent, false) as CardView

        return MyViewHolder(cardView)
    }

    override fun getItemCount(): Int = myDataSet.estructura.size

    override fun getItemViewType(position: Int): Int {
        return when(myDataSet.estructura[position]){
            0 -> TYPE_TEXTVIEW
            1 -> TYPE_IMAGEVIEW
            2 -> TYPE_SUBSECTION
            else -> throw java.lang.IllegalArgumentException("Invalid type of data " + position)
        }
    }

    override fun onBindViewHolder(holder: LeccionAdapter.MyViewHolder, position: Int) {
/*        if(!titleShown){
            holder.title.text = myDataSet.title
            titleShown = true
        }
        if(getItemViewType(position) == 0){
            holder.textBlock.text = myDataSet.textBlock[textBlockCounter]
            textBlockCounter++
        } else if(getItemViewType(position) == 1){
            holder.imageView.setImageResource(myDataSet.images[imageCounter])
            holder.imageView.setTag(myDataSet.images[imageCounter])
            imageCounter++
        } else if(getItemViewType(position) == 2){
            holder.subsection.text = myDataSet.subseccion[subSectionCounter]
        }

        if(holder.imageView.getTag() ==  null){
            holder.imageView.visibility = View.GONE
        }
        if(myDataSet.estructura[position] != ){
            Log.d("CardView title", holder.title.text as String)
            holder.title.visibility = View.GONE
        }
        Log.d("CardView title", holder.title.text as String)
        Log.d("CardView subsection", holder.subsection.text as String)
        if(holder.subsection == null){
            Log.d("CardView subsection", holder.subsection.text as String)
            holder.subsection.visibility = View.GONE
        }*/
        when(getItemViewType(position)){
            TYPE_TEXTVIEW -> {
                holder.textBlock.text = myDataSet.textBlock[textBlockCounter]
                textBlockCounter++
                holder.subsection.visibility = View.GONE
                holder.imageView.visibility = View.GONE
            }
            TYPE_SUBSECTION -> {
                holder.subsection.text = myDataSet.subseccion[subSectionCounter]
                subSectionCounter++
                if(!titleShown){
                    holder.title.text = myDataSet.title
                    holder.title.visibility = View.VISIBLE
                    titleShown = true
                }
                holder.imageView.visibility = View.GONE
            }
            TYPE_IMAGEVIEW -> {
                holder.imageView.setImageResource(myDataSet.images[imageCounter])
                holder.title.visibility = View.GONE
                holder.subsection.visibility = View.GONE
            }
        }
    }

}

/*
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
                item.textSize = 20F
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

    override fun getItemId(position: Int): Long {
        return position.toLong()
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
        adapterDataList.add(holder.itemView)
        val element = adapterDataList[position]
        when(holder){
            is TextViewHolder -> {
                holder.bind(element as TextView)
            }
            is ImageViewHolder -> {
                holder.bind(element as ImageView)
            }
            else -> throw java.lang.IllegalArgumentException()
        }
    }

}*/