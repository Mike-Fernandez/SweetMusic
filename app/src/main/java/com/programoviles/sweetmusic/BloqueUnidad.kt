package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.programoviles.sweetmusic.databinding.FragmentBloqueUnidadBinding
import kotlinx.android.synthetic.main.fragment_afinador.view.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class BloqueUnidad : Fragment(), OnLessonClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var dataSet: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentBloqueUnidadBinding>(inflater, R.layout.fragment_bloque_unidad,
            container, false)

        val b = arguments
        val unidadNum = b?.getInt("unidad")

        when(unidadNum){
            1 -> dataSet = resources.getStringArray(R.array.unidad1)
            2 -> dataSet = resources.getStringArray(R.array.unidad2)
            3 -> dataSet = resources.getStringArray(R.array.unidad3)
            4 -> dataSet = resources.getStringArray(R.array.unidad4)
            5 -> dataSet = resources.getStringArray(R.array.unidad5)
            6 -> dataSet = resources.getStringArray(R.array.unidad6)
            else -> throw Exception("Unidad no seleccionada")
        }



        viewManager = LinearLayoutManager(this.context)
        //Adapter recibe el metodo parte de la interfaz especificado por el fragmento
        viewAdapter = UnidadAdapter(dataSet, this)

        recyclerView = binding.recyclerViewUnidad?.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }!!




        binding.toolbarMainMenu.setOnNavigationItemReselectedListener{
            when(it.itemId){
                R.id.glosario_access -> this.findNavController().navigate(R.id.action_bloqueUnidad_to_glosarioFragment3)
                R.id.metronomo_access -> this.findNavController().navigate(R.id.action_bloqueUnidad_to_metronomo)
                R.id.chord_access -> this.findNavController().navigate(R.id.action_bloqueUnidad_to_acordesFragment2)
                R.id.afinador_access -> this.findNavController().navigate(R.id.action_bloqueUnidad_to_afinador2)
            }
        }
        return binding.root
    }

    //Funcion que define accion de cuando se presiona un titulo de leccion
    override fun onItemClick(lesson: String, position: Int) {
        if(lesson.contains("Exámen")){
            val args = Bundle()
            args.putString("unidad", lesson)
            this.findNavController().navigate(R.id.action_bloqueUnidad_to_examenFragment, args)
        } else {
            val args = Bundle()
            args.putString("lesson", lesson)
            this.findNavController().navigate(R.id.action_bloqueUnidad_to_bloqueLeccion, args)
        }
    }
}
