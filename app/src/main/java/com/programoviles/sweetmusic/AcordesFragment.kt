package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentAcordesBinding

/**
 * A simple [Fragment] subclass.
 */
class AcordesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentAcordesBinding>(inflater, R.layout.fragment_acordes,
            container, false)

//        val spinnerAcordes = binding.spChordName
        val spinnerAcordes: Spinner = binding.spChordName
        this.context?.let {
            ArrayAdapter.createFromResource(it, R.array.acordes_array, android.R.layout.simple_spinner_item)
                .also { adapter->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinnerAcordes.adapter = adapter
                }
        }


        binding.toolbarAcordesMenu.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.glosario_access_acordes -> findNavController().navigate(R.id.action_acordesFragment_to_glosarioFragment)
                R.id.afinador_access_acordes -> findNavController().navigate(R.id.action_acordesFragment_to_afinador)
                R.id.home_access_acordes -> findNavController().navigate(R.id.action_acordesFragment_to_mainMenuFragment)
                R.id.metronomo_access_acordes -> findNavController().navigate(R.id.action_acordesFragment_to_metronomo)
            }
        }

        return binding.root
    }

}
