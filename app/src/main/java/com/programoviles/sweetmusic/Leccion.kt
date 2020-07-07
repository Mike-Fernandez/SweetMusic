package com.programoviles.sweetmusic

class Leccion(
    var title: String,
    var estructura: Array<Int>,
    var textBlock: Array<String>,
    var images: Array<Int>,
    var subseccion: Array<String>
){
    companion object{
        private const val TYPE_TEXT_IMAGE = 0
        private const val TYPE_AUDIO = 1
        private const val ESTRUCTURA_TEXT = 0
        private const val ESTRUCTURA_IMAGE = 1
        private const val ESTRUCTURA_SECTION = 2
        private const val ESTRUCTURA_TITLE = 3
    }
}