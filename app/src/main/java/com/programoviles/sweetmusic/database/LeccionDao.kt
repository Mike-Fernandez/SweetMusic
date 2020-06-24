package com.programoviles.sweetmusic.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LeccionDao{
    @Query("SELECT titulo FROM leccion WHERE unidad = :parte ")
    fun getTitulos(parte: String): List<String>

    @Insert
    fun insertLeccion(leccion: Leccion)

}