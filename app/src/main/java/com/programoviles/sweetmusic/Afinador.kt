package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentAcordesBinding

/**
 * A simple [Fragment] subclass.
 */
class Afinador : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentAcordesBinding>(inflater, R.layout.fragment_acordes,
        container, false)

        binding.toolbarAcordesMenu.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.acordes_access_afinador -> findNavController().navigate(R.id.action_afinador_to_acordesFragment)
                R.id.glosario_access_afinador -> findNavController().navigate(R.id.action_afinador_to_glosarioFragment)
                R.id.metronomo_access_afinador -> findNavController().navigate(R.id.action_afinador_to_metronomo)
                R.id.home_access_afinador -> findNavController().navigate(R.id.action_afinador_to_mainMenuFragment)
            }
        }

        return binding.root

        //return inflater.inflate(R.layout.fragment_afinador, container, false)
    }

}
