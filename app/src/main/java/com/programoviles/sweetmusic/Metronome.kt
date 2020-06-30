package com.programoviles.sweetmusic

import android.media.AudioManager
import android.media.ToneGenerator
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.timerTask

enum class MetronomeState {
    OFF,
    ON
}

object Metronome {
    const val BPM_LOWER_THRESHOLD: Long = 40L
    const val BPM_UPPER_THRESHOLD: Long = 210L

    private const val METRONOME_TONE = ToneGenerator.TONE_PROP_BEEP
    private const val MILLISECONDS_IN_SECOND: Int = 1000
    private const val SECONDS_IN_MINUTE: Int = 60

    private var metronomeState: MetronomeState
    private var metronome: Timer

    init {
        metronome = Timer("metronome", true)
        metronomeState = MetronomeState.OFF
    }

    private fun createNewTimer(){
        if (this.isOff()) {
            this.metronome = Timer("metronome", true)
        }
    }

    private fun calculateSleepDuration(bpm: Long): Long {
        return (MILLISECONDS_IN_SECOND * (SECONDS_IN_MINUTE / bpm.toDouble())).toLong()
    }

    fun start(bpm: Long): Boolean{
        if(this.isOn()){
            return false
        }

        this.metronomeState = MetronomeState.ON
        this.metronome.schedule(
            timerTask {
                val toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
                toneGenerator.startTone(METRONOME_TONE)
                toneGenerator.release()
            },
            0L, calculateSleepDuration(bpm)
        )

        return true
    }

    fun stop(): Boolean {
        if (this.isOff()) {
            return false
        }

        this.metronomeState = MetronomeState.OFF
        this.metronome.cancel()
        createNewTimer()

        return true
    }

    fun isOn(): Boolean {
        return this.metronomeState == MetronomeState.ON
    }

    fun isOff(): Boolean {
        return this.metronomeState == MetronomeState.OFF
    }
}