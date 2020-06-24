package com.programoviles.sweetmusic.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Leccion::class], version = 1, exportSchema =  false)
abstract class LeccionDatabase: RoomDatabase(){
    abstract val leccionDao: LeccionDao

    companion object{
        @Volatile
        private var INSTANCE: LeccionDatabase? = null

        fun getInstance(context: Context): LeccionDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LeccionDatabase::class.java,
                        "leccion_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}