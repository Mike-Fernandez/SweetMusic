package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.programoviles.sweetmusic.databinding.FragmentBloqueUnidadBinding

/**
 * A simple [Fragment] subclass.
 */
class BloqueUnidad : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentBloqueUnidadBinding>(inflater, R.layout.fragment_bloque_unidad,
            container, false)

        binding.btLeccion1.setOnClickListener {
            this.findNavController().navigate(R.id.action_bloqueUnidad_to_bloqueLeccion)
        }

        binding.btLeccion2.setOnClickListener {
            this.findNavController().navigate(R.id.action_bloqueUnidad_to_bloqueLeccion)
        }

        binding.btLeccion3.setOnClickListener {
            this.findNavController().navigate(R.id.action_bloqueUnidad_to_bloqueLeccion)
        }

        binding.btLeccion4.setOnClickListener {
            this.findNavController().navigate(R.id.action_bloqueUnidad_to_bloqueLeccion)
        }

        binding.btLeccion5.setOnClickListener {
            this.findNavController().navigate(R.id.action_bloqueUnidad_to_bloqueLeccion)
        }

        binding.btLeccion6.setOnClickListener {
            this.findNavController().navigate(R.id.action_bloqueUnidad_to_bloqueLeccion)
        }

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

}
