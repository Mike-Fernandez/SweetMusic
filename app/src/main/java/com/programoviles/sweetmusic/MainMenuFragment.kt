package com.programoviles.sweetmusic

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
            }
        }

        binding.toolbarMainMenu.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.chord_access -> this.findNavController().navigate(R.id.action_mainMenuFragment_to_acordesFragment)
            }
        }

        return binding.root
    }

}
