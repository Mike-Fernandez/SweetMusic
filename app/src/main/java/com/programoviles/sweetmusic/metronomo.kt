package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentMetronomoBinding


class metronomo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMetronomoBinding>(inflater,
            R.layout.fragment_metronomo,container,false)

        binding.toolbarMenuMetronomo.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.Home_access_metronomo -> this.findNavController().
                    navigate(R.id.action_metronomo_to_mainMenuFragment)
                R.id.glosario_access_metronomo -> this.findNavController().
                    navigate(R.id.action_metronomo_to_glosarioFragment)
                R.id.Afinador_access_metronomo -> this.findNavController().
                    navigate(R.id.action_metronomo_to_afinador)
                R.id.Acordes_access_metronomo -> this.findNavController().
                    navigate(R.id.action_metronomo_to_acordesFragment)
            }
        }

        return binding.root
    }

}
