package com.programoviles.sweetmusic

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.programoviles.sweetmusic.databinding.FragmentAcordesBinding
import kotlinx.android.synthetic.main.fragment_acordes.*

/**
 * A simple [Fragment] subclass.
 */
class AcordesFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var mp: MediaPlayer

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

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        //parent.getItemAtPosition(pos)
        //Toast.makeText(this.context,resources.getStringArray(R.array.acordes_array)[pos], Toast.LENGTH_LONG).show()
        when(pos){
            0 -> {//imagen
                imgChord.setImageResource(R.drawable.triadamayor)
                //texto
                AcordeName2.text = "3ra Mayor E"
                AcordeName3.text = "5ta Justa G"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.mayorasc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.mayordes)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.mayorarm)
                    mp.start()
                }
            }
            1 ->{//imagen
                imgChord.setImageResource(R.drawable.triadamenor)
                //texto
                AcordeName2.text = "3ra Menor Eb"
                AcordeName3.text = "5ta Justa G"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.menorasc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.menordes)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.menorarm)
                    mp.start()
                }
            }
            2 ->{//imagen
                imgChord.setImageResource(R.drawable.aug)
                //texto
                AcordeName2.text = "3ra Mayor E"
                AcordeName3.text = "5ta Aumentada G#"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.augasc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.augdes)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.augarm)
                    mp.start()
                }
            }
            3 -> {//imagen
                imgChord.setImageResource(R.drawable.dism)
                //texto
                AcordeName2.text = "3ra Menor Eb"
                AcordeName3.text = "5ta Disminuida Gb"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.dimasc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.dimdes)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.dimarm)
                    mp.start()
                }
            }
            4 -> {//imagen
                imgChord.setImageResource(R.drawable.power)
                //texto
                AcordeName2.text = "5ta Justa G"
                AcordeName3.text = "8va Justa C"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.powerasc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.powerdes)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.powerarm)
                    mp.start()
                }
            }
            5 ->{//imagen
                imgChord.setImageResource(R.drawable.sus2)
                //texto
                AcordeName2.text = "2da Mayor D"
                AcordeName3.text = "5ta Justa G"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.sus2asc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.sus2des)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.sus2arm)
                    mp.start()
                }
            }
            6 ->{//imagen
                imgChord.setImageResource(R.drawable.sus4)
                //texto
                AcordeName2.text = "4ta Justa F"
                AcordeName3.text = "5ta Justa G"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.sus4asc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.sus4des)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.sus4arm)
                    mp.start()
                }
            }
            7 -> {//imagen
                imgChord.setImageResource(R.drawable.mayor7)
                //texto
                AcordeName2.text = "3ra Mayor E"
                AcordeName3.text = "5ta Justa G"
                AcordeName4.text = "7ma menor Bb"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.mayor7asc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.mayor7des)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.mayor7arm)
                    mp.start()
                }
            }
            8 -> {
                //imagen
                imgChord.setImageResource(R.drawable.maj7)
                //texto
                AcordeName2.text = "3ra Mayor E"
                AcordeName3.text = "5ta Justa G"
                AcordeName4.text = "7ma Mayor B"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.mayor7mayorasc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.mayor7mayordes)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.mayor7mayorarm)
                    mp.start()
                }
            }
            9 ->{//imagen
                imgChord.setImageResource(R.drawable.menor7)
                //texto
                AcordeName2.text = "3ra Menor Eb"
                AcordeName3.text = "5ta Justa G"
                AcordeName4.text = "7ma Menor Bb"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.menor7asc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.menor7des)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.menor7arm)
                    mp.start()
                }
            }
            10 ->{//imagen
                imgChord.setImageResource(R.drawable.menormaj7)
                //texto
                AcordeName2.text = "3ra Menor Eb"
                AcordeName3.text = "5ta Justa G"
                AcordeName4.text = "7ma Mayor B"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.menormaj7asc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.menormaj7des)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.menor7mayorarm)
                    mp.start()
                }
            }
            11 ->{//imagen
                imgChord.setImageResource(R.drawable.aumentada7)
                //texto
                AcordeName2.text = "3ra Mayor E"
                AcordeName3.text = "5ta Aumentada G#"
                AcordeName4.text = "7ma Menor Bb"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.aumentada7asc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.aumentada7des)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.aumentada7arm)
                    mp.start()
                }
            }
            12 ->{//imagen
                imgChord.setImageResource(R.drawable.augmaj7)
                //texto
                AcordeName2.text = "3ra Mayor E"
                AcordeName3.text = "5ta Justa G"
                AcordeName4.text = "7ma Mayor B"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.augmaj7asc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.augmaj7)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.augmaj7arm)
                    mp.start()
                }
            }
            13 ->{//imagen
                imgChord.setImageResource(R.drawable.dim7)
                //texto
                AcordeName2.text = "3ra Menor Eb"
                AcordeName3.text = "5ta Disminuida Gb"
                AcordeName4.text = "7ma menor Bb"
                //ascendente audio
                button.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.dim7asc)
                    mp.start()
                }
                //descendente audio
                button2.setOnClickListener{
                    mp = MediaPlayer.create(this.context, R.raw.dim7des)
                    mp.start()
                }
                //armonico audio
                button3.setOnClickListener {
                    mp = MediaPlayer.create(this.context, R.raw.dim7arm)
                    mp.start()
                }
            }
        }

    }


}
