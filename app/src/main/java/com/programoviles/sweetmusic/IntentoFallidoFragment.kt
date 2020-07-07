package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentIntentoFallidoBinding


class IntentoFallidoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentIntentoFallidoBinding>(inflater,
            R.layout.fragment_intento_fallido, container, false)

        binding.failedReturnButton.setOnClickListener {
            this.findNavController().navigate(R.id.action_intentoFallidoFragment_to_mainMenuFragment)
        }

        return binding.root
    }

}