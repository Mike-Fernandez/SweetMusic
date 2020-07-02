package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentAcordesBinding
import kotlinx.android.synthetic.main.fragment_acordes.*

/**
 * A simple [Fragment] subclass.
 */
class AcordesFragment : Fragment(), AdapterView.OnItemSelectedListener {

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
                    spinnerAcordes.onItemSelectedListener = this
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

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        //parent.getItemAtPosition(pos)
        //Toast.makeText(this.context,resources.getStringArray(R.array.acordes_array)[pos], Toast.LENGTH_LONG).show()
        when(pos){
            0 -> imgChord.setImageResource(R.drawable.triadamayor)
            1 -> imgChord.setImageResource(R.drawable.triadamenor)
            2 -> imgChord.setImageResource(R.drawable.aug)
            3 -> imgChord.setImageResource(R.drawable.dism)
            4 -> imgChord.setImageResource(R.drawable.power)
            5 -> imgChord.setImageResource(R.drawable.sus2)
            6 -> imgChord.setImageResource(R.drawable.sus4)
            7 -> imgChord.setImageResource(R.drawable.mayor7)
            8 -> imgChord.setImageResource(R.drawable.maj7)
            9 -> imgChord.setImageResource(R.drawable.menor7)
            10 -> imgChord.setImageResource(R.drawable.menormaj7)
            11 -> imgChord.setImageResource(R.drawable.augmaj7)
            12 -> imgChord.setImageResource(R.drawable.aumentada7)
            13 -> imgChord.setImageResource(R.drawable.dim7)
        }

    }


}
