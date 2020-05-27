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
import kotlinx.android.synthetic.main.fragment_afinador.*

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
            mp = MediaPlayer.create(this.context, R.raw.e1)
            mp.start()
        }

        binding.bt2da.setOnClickListener {
            mp = MediaPlayer.create(this.context, R.raw.b2)
            mp.start()
        }

        binding.bt3ra.setOnClickListener {
            mp = MediaPlayer.create(this.context, R.raw.g3)
            mp.start()
        }

        binding.bt4ta.setOnClickListener {
            mp = MediaPlayer.create(this.context, R.raw.d4)
            mp.start()
        }

        binding.bt5ta.setOnClickListener {
            mp = MediaPlayer.create(this.context, R.raw.a5)
            mp.start()
        }

        binding.bt6ta.setOnClickListener {
            mp = MediaPlayer.create(this.context, R.raw.e6)
            mp.start()
        }

        return binding.root

    }

}
