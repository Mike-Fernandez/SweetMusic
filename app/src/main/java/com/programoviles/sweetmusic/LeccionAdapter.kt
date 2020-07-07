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
    private var adapterDataList = mutableListOf<Any>()

    companion object {
        private const val PrimaryColor = "#6200EE"
        private const val DarkPrimaryColor = "#3700B3"
        private const val TYPE_TEXTVIEW = 0
        private const val TYPE_IMAGEVIEW = 1
        private const val TYPE_SUBSECTION = 2
        private const val TYPE_TITLE = 3
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
            3 -> TYPE_TITLE
            else -> throw java.lang.IllegalArgumentException("Invalid type of data " + position)
        }
    }

    fun defineLesson(){
        var counter = 0
        var textBlockCounter = 0
        var subSectionCounter = 0
        var imageCounter = 0

        adapterDataList.add(myDataSet.title)
        for(i in 0 until myDataSet.estructura.size){
            when(myDataSet.estructura[i]){
                TYPE_TEXTVIEW -> {
                    adapterDataList.add(myDataSet.textBlock[textBlockCounter])
                    textBlockCounter++
                }
                TYPE_SUBSECTION -> {
                    adapterDataList.add(myDataSet.subseccion[subSectionCounter])
                    subSectionCounter++
                }
                TYPE_IMAGEVIEW -> {
                    adapterDataList.add(myDataSet.images[imageCounter])
                    imageCounter++
                }
            }
        }
    }

    override fun onBindViewHolder(holder: LeccionAdapter.MyViewHolder, position: Int) {
        defineLesson()
        when(getItemViewType(position)){
            TYPE_TEXTVIEW -> {
                holder.textBlock.text = adapterDataList[position] as String
                holder.subsection.visibility = View.GONE
                holder.imageView.visibility = View.GONE
            }
            TYPE_SUBSECTION -> {
                holder.subsection.text = adapterDataList[position] as String
                holder.imageView.visibility = View.GONE
            }
            TYPE_IMAGEVIEW -> {
                holder.imageView.setImageResource(adapterDataList[position] as Int)
                holder.title.visibility = View.GONE
                holder.subsection.visibility = View.GONE
            }
            TYPE_TITLE -> {
                holder.title.text = adapterDataList[position] as String
                holder.subsection.visibility = View.GONE
                holder.imageView.visibility = View.GONE
            }
        }
    }

}
