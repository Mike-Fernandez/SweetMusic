package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentGlosarioBinding

/**
 * A simple [Fragment] subclass.
 */
class Glosario : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGlosarioBinding>(inflater, R.layout.fragment_glosario,
                    container, false)

        binding.toolbarGlosarioMenu.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.Home_access_glosario -> findNavController().navigate(R.id.action_glosarioFragment_to_mainMenuFragment)
                R.id.acordes_access_glosario -> findNavController().navigate(R.id.action_glosarioFragment_to_acordesFragment)
                R.id.metronomo_access_glosario -> findNavController().navigate(R.id.action_glosarioFragment_to_metronomo)
                R.id.afinador_access_glosario -> findNavController().navigate(R.id.action_glosarioFragment_to_afinador)
            }
        }

        return binding.root
    }

}

