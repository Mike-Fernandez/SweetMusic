package com.programoviles.sweetmusic.database

import androidx.room.Entity

@Entity(tableName = "leccion")
data class Leccion(
    var titulo: String,
//    var estructura: String = "yoSoyLeccion1",
    var texto: String,
    var images: String,
    var audios: String
)

//"texto@@a@@texto@@i"