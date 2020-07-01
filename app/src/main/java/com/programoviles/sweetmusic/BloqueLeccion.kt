package com.programoviles.sweetmusic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.programoviles.sweetmusic.databinding.FragmentBloqueLeccionBinding

/**
 * A simple [Fragment] subclass.
 */
class BloqueLeccion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentBloqueLeccionBinding>(inflater, R.layout.fragment_bloque_leccion,
            container, false)

        Log.d("Arguments for Lesson", arguments?.getString("lesson"))

        binding.tvLessonTitle.text = arguments?.getString("lesson")

        return binding.root
//        return inflater.inflate(R.layout.fragment_bloque_leccion, container, false)
    }

}
