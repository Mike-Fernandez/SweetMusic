package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentPassedExamBinding


class PassedExamFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPassedExamBinding>(inflater,
            R.layout.fragment_passed_exam, container, false)

        binding.passedReturnButton.setOnClickListener {
            this.findNavController().navigate(R.id.action_passedExamFragment_to_mainMenuFragment)
        }

        return binding.root
    }
}