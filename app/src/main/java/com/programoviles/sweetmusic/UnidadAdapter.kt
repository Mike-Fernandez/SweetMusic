package com.programoviles.sweetmusic

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_afinador.view.*

//Adapter recibe objeto de interfaz
class UnidadAdapter(private val myDataSet: Array<String>, var clickListener: OnLessonClickListener) : RecyclerView.Adapter<UnidadAdapter.MyViewHolder>(){

    //ViewHolder incluye funcion que recibe mismos parametros que funcion de interfaz
    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView){

        //Funcion a ejecutar en el ViewHolderBind
        fun initialize(lesson: String, action: OnLessonClickListener){
            textView.setOnClickListener {
                action.onItemClick(textView.text.toString(), adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.textview, parent, false) as TextView
        textView.textSize = 20F
        return MyViewHolder(textView)
    }

    //Se le da los valores a los textos y se llama a initialize para darle clicklistener a cada item
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myDataSet[position]
        holder.initialize(myDataSet[position], clickListener)
    }

/*    class MyViewHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.textview, parent, false) as TextView
        val imageView = LayoutInflater.from(parent.context)
            .inflate(R.layout.imageview, parent, false) as ImageView


    }*/

    override fun getItemCount() = myDataSet.size
}

//Interfaz de funcion clicklistener
interface OnLessonClickListener{
    fun onItemClick(lesson: String, position: Int)
}