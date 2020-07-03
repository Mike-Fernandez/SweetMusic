package com.programoviles.sweetmusic

class LessonElement(
    var type: Int,
    var data: Int,
    var texto: String
){
    companion object{
        private const val TEXT = 0
        private const val IMAGE = 1
        private const val AUDIO = 2
    }

}