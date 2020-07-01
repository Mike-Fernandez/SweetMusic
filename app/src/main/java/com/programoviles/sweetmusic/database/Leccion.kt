package com.programoviles.sweetmusic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leccion")
data class Leccion(
    @PrimaryKey(autoGenerate = false)
    var titulo: String,

    @ColumnInfo(name = "hasAudio")
    var hasAudio: Boolean,

    @ColumnInfo(name = "unidad")
    var unidad: String,
    var estructura: String
//    var texto: String,
//    var images: String,
//    var audios: String
)

//"texto@@a@@texto@@i1"