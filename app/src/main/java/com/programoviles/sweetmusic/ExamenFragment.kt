package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.programoviles.sweetmusic.databinding.FragmentExamenBinding
import com.programoviles.sweetmusic.databinding.FragmentGlosarioBinding


class ExamenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentExamenBinding>(inflater, R.layout.fragment_examen,
            container, false)

        return binding.root
    }

}