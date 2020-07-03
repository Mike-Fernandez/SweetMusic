package com.programoviles.sweetmusic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.programoviles.sweetmusic.databinding.FragmentBloqueLeccionBinding
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class BloqueLeccion : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var dataSet: Leccion
//    private lateinit var dataSet: Array<Map<String, String>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentBloqueLeccionBinding>(inflater, R.layout.fragment_bloque_leccion,
            container, false)

        Log.d("Arguments for Lesson", arguments?.getString("lesson"))
        var titleTextView = binding.tvLessonTitle
        titleTextView.text = arguments?.getString("lesson")

        when(arguments?.getString("lesson")){
            "Lección 1: El sonido" -> {
                dataSet = Leccion("Lección 1: El sonido", arrayOf(0) , arrayOf("Hola"), arrayOf(0,1),
                    null, 0)
            }
            else -> {
                throw Exception("Leccion no encontrada")
            }
        }

        viewManager = LinearLayoutManager(this.context)
        //Adapter recibe el metodo parte de la interfaz especificado por el fragmento
        viewAdapter = LeccionAdapter(dataSet, titleTextView)

        recyclerView = binding.recyclerViewLeccion?.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }!!

        return binding.root
    }

}
