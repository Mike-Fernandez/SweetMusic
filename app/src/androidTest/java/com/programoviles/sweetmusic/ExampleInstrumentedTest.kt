package com.programoviles.sweetmusic

import android.util.Log
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.programoviles.sweetmusic.database.Leccion
import com.programoviles.sweetmusic.database.LeccionDao
import com.programoviles.sweetmusic.database.LeccionDatabase
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var lessonDao: LeccionDao
    private lateinit var db: LeccionDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, LeccionDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        lessonDao = db.leccionDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetNight() {
        val leccion = Leccion("El sonido", false, "unidad 1")
        val leccion2 = Leccion("La musica", false, "unidad 1")
        lessonDao.insertLeccion(leccion)
        lessonDao.insertLeccion(leccion2)
        Log.d("lesson Title Test", "${leccion.titulo}")
        val lesson1 = lessonDao.getTitulos("unidad 1")
        Log.d("lesson Title Test", "${lesson1}")
        assertEquals(lesson1, -1)
    }


}

