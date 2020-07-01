package com.programoviles.sweetmusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentMainMenuBinding

/**
 * A simple [Fragment] subclass.
 */
class MainMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainMenuBinding>(inflater, R.layout.fragment_main_menu,
                        container, false)

        binding.toolbarMainMenu.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.glosario_access -> this.findNavController().navigate(R.id.action_mainMenuFragment_to_glosario)
                R.id.metronomo_access -> this.findNavController().navigate(R.id.action_mainMenuFragment_to_metronomo)
                R.id.chord_access -> this.findNavController().navigate(R.id.action_mainMenuFragment_to_acordesFragment)
                R.id.afinador_access -> this.findNavController().navigate(R.id.action_mainMenuFragment_to_afinador)
            }
        }

        binding.btUnidad1.setOnClickListener {
            val args = Bundle()
            args.putInt("unidad", 1)
            this.findNavController().navigate(R.id.action_mainMenuFragment_to_bloqueUnidad, args)
        }

        binding.btUnidad2.setOnClickListener {
            val args = Bundle()
            args.putInt("unidad", 2)
            this.findNavController().navigate(R.id.action_mainMenuFragment_to_bloqueUnidad, args)
        }

        binding.btUnidad3.setOnClickListener {
            val args = Bundle()
            args.putInt("unidad", 3)
            this.findNavController().navigate(R.id.action_mainMenuFragment_to_bloqueUnidad, args)
        }

        binding.btUnidad4.setOnClickListener {
            val args = Bundle()
            args.putInt("unidad", 4)
            this.findNavController().navigate(R.id.action_mainMenuFragment_to_bloqueUnidad, args)
        }

        binding.btUnidad5.setOnClickListener {
            val args = Bundle()
            args.putInt("unidad", 5)
            this.findNavController().navigate(R.id.action_mainMenuFragment_to_bloqueUnidad, args)
        }

        binding.btUnidad6.setOnClickListener {
            val args = Bundle()
            args.putInt("unidad", 6)
            this.findNavController().navigate(R.id.action_mainMenuFragment_to_bloqueUnidad, args)
        }
        
        return binding.root
    }

}
