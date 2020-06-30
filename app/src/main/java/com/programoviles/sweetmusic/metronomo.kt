package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentMetronomoBinding
import android.media.ToneGenerator
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_metronomo.*


class metronomo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMetronomoBinding>(inflater,
            R.layout.fragment_metronomo,container,false)

        Log.d("Metronome BPM", "${binding.etBPM.text}")

        binding.etBPM.setOnTouchListener{_, _->
            binding.etBPM.isCursorVisible = true

            false
        }

        binding.etBPM.setOnEditorActionListener { _, keyCode: Int?, _ ->
            if (keyCode == EditorInfo.IME_ACTION_DONE) {
                binding.etBPM.isCursorVisible = false
            }

            false
        }

        binding.etBPM.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val currentBPM = getCurrentBpm()
                showCurrentBpmError(currentBPM == 0L || !checkBpmBounds(currentBPM))
            }
        })

        binding.metronomeSwitch.setOnCheckedChangeListener{_, isChecked->
            updateMetronomeStatus(isChecked)
        }

        binding.toolbarMenuMetronomo.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.Home_access_metronomo -> this.findNavController().
                    navigate(R.id.action_metronomo_to_mainMenuFragment)
                R.id.glosario_access_metronomo -> this.findNavController().
                    navigate(R.id.action_metronomo_to_glosarioFragment)
                R.id.Afinador_access_metronomo -> this.findNavController().
                    navigate(R.id.action_metronomo_to_afinador)
                R.id.Acordes_access_metronomo -> this.findNavController().
                    navigate(R.id.action_metronomo_to_acordesFragment)
            }
        }

        updateBpmButtons()
        return binding.root
    }

    private fun updateMetronomeStatus(status: Boolean) {
        if (status) {
            val currentBpm = getCurrentBpm()
            if (currentBpm != 0L && checkBpmBounds(currentBpm)) {
                Metronome.start(currentBpm)
            }
        } else {
            Metronome.stop()
        }

        updateBpmButtons()
    }

    fun getCurrentBpm(): Long {
        if (etBPM.text.toString() != 0.toString()) {
            return etBPM.text.toString().toLong()
        } else {
            return 0L
        }
    }

    private fun checkBpmBounds(bpm: Long): Boolean {
        return (bpm in Metronome.BPM_LOWER_THRESHOLD..Metronome.BPM_UPPER_THRESHOLD)
    }

    private fun showCurrentBpmError(showError: Boolean) {
        etBPM.error = if (showError) "BPM must be between ${Metronome.BPM_LOWER_THRESHOLD} and ${Metronome.BPM_UPPER_THRESHOLD}" else null
    }

    private fun enableCurrentBpm() {
        etBPM.isEnabled = true
    }

    private fun disableCurrentBpm() {
        etBPM.isEnabled = false
    }

    private fun enableMetronomeSwitch() {
        metronomeSwitch.isEnabled = true
    }

    private fun disableMetronomeSwitch(){
        metronomeSwitch.isEnabled = false
    }

    private fun updateBpmButtons() {
        val currentBpm = getCurrentBpm()

        when {
            currentBpm == 0L -> {
                disableMetronomeSwitch()
            }
            currentBpm < Metronome.BPM_LOWER_THRESHOLD -> {
                disableMetronomeSwitch()
            }
            currentBpm == Metronome.BPM_LOWER_THRESHOLD -> {
                enableMetronomeSwitch()
                if (Metronome.isOff()) {
                    enableCurrentBpm()
                } else {
                    disableCurrentBpm()
                }
            }
            currentBpm < Metronome.BPM_UPPER_THRESHOLD -> {
                enableMetronomeSwitch()
                if (Metronome.isOff()) {
                    enableCurrentBpm()
                } else {
                    disableCurrentBpm()
                }
            }
            currentBpm == Metronome.BPM_UPPER_THRESHOLD -> {
                enableMetronomeSwitch()
                if (Metronome.isOff()) {
                    enableCurrentBpm()
                } else {
                    disableCurrentBpm()
                }
            }
            else -> {
                disableMetronomeSwitch()
            }
        }
    }

}
