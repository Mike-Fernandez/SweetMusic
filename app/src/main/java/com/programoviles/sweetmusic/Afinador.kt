package com.programoviles.sweetmusic

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentAfinadorBinding

/**
 * A simple [Fragment] subclass.
 */
class Afinador : Fragment() {

    private lateinit var mp: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentAfinadorBinding>(inflater, R.layout.fragment_afinador,
        container, false)

        binding.toolbarMenuAfinador.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.acordes_access_afinador -> findNavController().navigate(R.id.action_afinador_to_acordesFragment)
                R.id.glosario_access_afinador -> findNavController().navigate(R.id.action_afinador_to_glosarioFragment)
                R.id.metronomo_access_afinador -> findNavController().navigate(R.id.action_afinador_to_metronomo)
                R.id.home_access_afinador -> findNavController().navigate(R.id.action_afinador_to_mainMenuFragment)
            }
        }

        binding.bt1ra.setOnClickListener {
            mp = MediaPlayer.create(this.context, R.raw.a)
            mp.start()
            Log.i("TunerActivity", "Pressed Tuner Button")
        }

        return binding.root

    }

}
