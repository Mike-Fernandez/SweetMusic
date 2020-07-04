package com.programoviles.sweetmusic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.programoviles.sweetmusic.databinding.FragmentBloqueLeccionBinding
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class BloqueLeccion : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var dataSet: ArrayList<Any>
//    private lateinit var dataSet: Array<Map<String, String>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentBloqueLeccionBinding>(inflater, R.layout.fragment_bloque_leccion,
            container, false)

        Log.d("Arguments for Lesson", arguments?.getString("lesson"))
        var titleTextView = binding.tvLessonTitle
        titleTextView.text = arguments?.getString("lesson")

        when(arguments?.getString("lesson")){
            "Lección: 1 El sonido" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L1T1), resources.getString(R.string.L1T2), R.drawable.imagen1)
            }
            "Lección: 2 Propiedades del sonido"-> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L2T1), resources.getString(R.string.L2T2), R.drawable.imagen2, resources.getString(R.string.L2T3), R.drawable.imagen3, "imagen de ecualizador gráfico")
            }
            "Lección: 3 Introducción a la música" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L3T1), resources.getString(R.string.L3T2), R.drawable.imagen4, resources.getString(R.string.L3T3), resources.getString(R.string.L3T4), resources.getString(R.string.L3T5), R.drawable.imagen6, resources.getString(R.string.L3T6), R.drawable.imagen8 )

            }
            "Lección: 4 Introducción a la música(Continuación)" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L4T1), resources.getString(R.string.L4T2), R.drawable.imagen9, resources.getString(R.string.L4T3), R.drawable.imagen10)

            }
            "Lección: 5 Alteraciones y Diatonismo vs cromatismo" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L5T1), resources.getString(R.string.L5T2), R.drawable.imagen11, resources.getString(R.string.L5T3), R.drawable.imagen12, resources.getString(R.string.L5T4), R.drawable.imagen13, resources.getString(R.string.L5T5), resources.getString(R.string.L5T6))
            }
            "Lección: 6 Introducción a la lectura musical (Claves y notas)" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L6T1), resources.getString(R.string.L6T2), R.drawable.imagen14, resources.getString(R.string.L6T3), resources.getString(R.string.L6T4), R.drawable.imagen15, resources.getString(R.string.L6T5), R.drawable.imagen16, resources.getString(R.string.L6T6), resources.getString(R.string.L6T7), R.drawable.imagen17, resources.getString(R.string.L6T8), R.drawable.imagen18)

            }
            "Lección: 7 Lectura musical I" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L7T1), resources.getString(R.string.L7T2), resources.getString(R.string.L7T3), resources.getString(R.string.L7T4), R.drawable.imagen19, resources.getString(R.string.L7T5), resources.getString(R.string.L7T6), R.drawable.imagen20, resources.getString(R.string.L7T7), resources.getString(R.string.L7T8), R.drawable.metro)
            }
            "Lección: 8 Lectura musical II" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L8T1), resources.getString(R.string.L8T2), R.drawable.imagen21, resources.getString(R.string.L8T3), resources.getString(R.string.L8T4), resources.getString(R.string.L8T5), R.drawable.imagen22, resources.getString(R.string.L8T6), R.drawable.imagen23, resources.getString(R.string.L8T7), resources.getString(R.string.L8T8), R.drawable.ligadura)
            }
            "Lección: 9 Lectura musical III" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L9T1), resources.getString(R.string.L9T2), R.drawable.imagen24)
            }
            "Lección: 10 Teoría rítmica I" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L10T1), resources.getString(R.string.L10T2), R.drawable.imagen25, resources.getString(R.string.L10T3), resources.getString(R.string.L10T4), R.drawable.imagen26)
            }
            "Lección: 11 Teoría rítmica II" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L11T1), resources.getString(R.string.L11T2), R.drawable.imagen27, resources.getString(R.string.L11T3), resources.getString(R.string.L11T4), R.drawable.imagen28, resources.getString(R.string.L11T5))
            }
            "Lección: 12 Sincopa vs contratiempo" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L12T1), resources.getString(R.string.L12T2), R.drawable.sincopa, resources.getString(R.string.L12T3), R.drawable.contra)
            }
            "Lección: 13 Signos de repetición, dinámicas y artículaciones" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L13T1), resources.getString(R.string.L13T2), R.drawable.imagen29, resources.getString(R.string.L13T3), R.drawable.imagen30, resources.getString(R.string.L13T4), R.drawable.imagen31, resources.getString(R.string.L13T5), resources.getString(R.string.L13T6), resources.getString(R.string.L13T7), R.drawable.dinamica, resources.getString(R.string.L13T8), resources.getString(R.string.L13T9), R.drawable.arti)
            }
            "Lección: 14 Introducción a las escalas" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L14T1), resources.getString(R.string.L14T2), R.drawable.grados, resources.getString(R.string.L14T3), resources.getString(R.string.L14T4))
            }
            "Lección: 15 Escala Mayor Natural" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L15T1), resources.getString(R.string.L15T2), resources.getString(R.string.L15T3), resources.getString(R.string.L15T4), R.drawable.imagen32, resources.getString(R.string.L15T5), R.drawable.imagen33)
            }
            "Lección: 16 Escala Menor Natural" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L16T1), resources.getString(R.string.L16T2), resources.getString(R.string.L16T3), resources.getString(R.string.L16T4), R.drawable.imagen34)
            }
            "Lección: 17 Tonalidades<" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L17T1), resources.getString(R.string.L17T2), R.drawable.imagen35, resources.getString(R.string.L17T3), resources.getString(R.string.L17T4), resources.getString(R.string.L17T5), R.drawable.imagen36, resources.getString(R.string.L17T6), R.drawable.imagen37, resources.getString(R.string.L17T7), resources.getString(R.string.L17T8))
            }
            "Lección: 18 Escala Pentatónica y armónica" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L18T1), resources.getString(R.string.L18T2), resources.getString(R.string.L18T3), resources.getString(R.string.L18T4), R.drawable.imagen38, resources.getString(R.string.L18T5), resources.getString(R.string.L18T6), resources.getString(R.string.L18T7), R.drawable.imagen39, resources.getString(R.string.L18T8), resources.getString(R.string.L18T9), R.drawable.imagen40)
            }
            "Lección: 19 Escala menor bachiana, menor melódica y cromática" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L19T1), resources.getString(R.string.L19T2), R.drawable.imagen41, resources.getString(R.string.L19T3), resources.getString(R.string.L19T4), R.drawable.imagen42, resources.getString(R.string.L19T5), resources.getString(R.string.L19T6), R.drawable.imagen43, resources.getString(R.string.L19T7))
            }
            "Lección: 20 Intervalos" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L20T1), resources.getString(R.string.L20T2), R.drawable.imagen44, resources.getString(R.string.L20T3), resources.getString(R.string.L20T4), resources.getString(R.string.L20T5), R.drawable.imagen45, resources.getString(R.string.L20T6), resources.getString(R.string.L20T7), R.drawable.imagen46, resources.getString(R.string.L20T8), resources.getString(R.string.L20T9), R.drawable.imagen47, resources.getString(R.string.L20T10), resources.getString(R.string.L20T11), R.drawable.imagen48, resources.getString(R.string.L20T12), resources.getString(R.string.L20T13), R.drawable.imagen49, resources.getString(R.string.L20T14), resources.getString(R.string.L20T15), R.drawable.imagen50, resources.getString(R.string.L20T16), resources.getString(R.string.L20T17), R.drawable.imagen51, resources.getString(R.string.L20T18), resources.getString(R.string.L20T19), R.drawable.imagen52, resources.getString(R.string.L20T20), resources.getString(R.string.L20T21), R.drawable.imagen53 )
            }
            "Lección: 21 Intervalos II" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L21T1), resources.getString(R.string.L21T2), R.drawable.imagen54, resources.getString(R.string.L21T3), resources.getString(R.string.L21T4), resources.getString(R.string.L21T5), resources.getString(R.string.L21T6), resources.getString(R.string.L21T7), resources.getString(R.string.L21T8), resources.getString(R.string.L21T9), resources.getString(R.string.L21T10), R.drawable.imagen55, resources.getString(R.string.L21T11))

            }
            "Lección: 22 Acordes I" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L22T1), resources.getString(R.string.L22T2), resources.getString(R.string.L22T3),  resources.getString(R.string.L22T4), resources.getString(R.string.L22T5), R.drawable.imagen56, "Un acorde D", resources.getString(R.string.L22T6), R.drawable.imagen57, "Un acorde Gm7")
            }
            "Lección: 23 Acordes II" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L23T1), R.drawable.imagen58, "Acorde C aug", resources.getString(R.string.L23T2), R.drawable.imagen59, "Acorde B dim", resources.getString(R.string.L23T3), resources.getString(R.string.L23T4), R.drawable.imagen60, resources.getString(R.string.L23T5), resources.getString(R.string.L23T6)    )
            }
            "Lección: 24 Acordes III" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L24T1), resources.getString(R.string.L24T2), R.drawable.imagen61, resources.getString(R.string.L24T3), resources.getString(R.string.L24T4), R.drawable.imagen62, resources.getString(R.string.L24T5), resources.getString(R.string.L24T6), R.drawable.imagen63, "Acorde C add2")
            }
            "Lección: 25 Acordes IV" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L25T1), resources.getString(R.string.L25T2), resources.getString(R.string.L25T3),  R.drawable.imagen64, "Acorde C Maj7", resources.getString(R.string.L25T4),  R.drawable.imagen65, "Acorde G7", resources.getString(R.string.L25T5), resources.getString(R.string.L25T6), R.drawable.imagen66, resources.getString(R.string.L25T7) )
            }
            "Lección: 26 Acordes V" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L26T1), resources.getString(R.string.L26T2), R.drawable.imagen67, "Acorde B° maj7", resources.getString(R.string.L26T3), resources.getString(R.string.L26T4), R.drawable.imagen68, "Acorde A# add9", resources.getString(R.string.L26T5), resources.getString(R.string.L26T6), R.drawable.imagen69, "Ejemplos de inversiones")
            }
            "Lección: 27 Introducción a las escalas modales" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L27T1), resources.getString(R.string.L27T2), R.drawable.imagen70, resources.getString(R.string.L27T3), R.drawable.imagen71)
            }
            "Lección: 28 Modos mayores" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L28T1), resources.getString(R.string.L28T2),resources.getString(R.string.L28T3), resources.getString(R.string.L28T4), resources.getString(R.string.L28T5), resources.getString(R.string.L28T6) )
            }
            "Lección: 29 Modos menores" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L29T1), resources.getString(R.string.L29T2),resources.getString(R.string.L29T3), resources.getString(R.string.L29T4), resources.getString(R.string.L29T5), resources.getString(R.string.L29T6), resources.getString(R.string.L29T7), resources.getString(R.string.L29T8))
            }
            "Lección: 30 Otras escalas I" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L30T1), resources.getString(R.string.L30T2), R.drawable.imagen72, resources.getString(R.string.L30T3), resources.getString(R.string.L30T4),resources.getString(R.string.L30T5), resources.getString(R.string.L30T6), resources.getString(R.string.L30T7), resources.getString(R.string.L30T8), resources.getString(R.string.L30T9), resources.getString(R.string.L30T10))
            }
            "Lección: 31 Otras escalas II" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L31T1), resources.getString(R.string.L31T2),resources.getString(R.string.L31T3), resources.getString(R.string.L31T4), R.drawable.imagen73, resources.getString(R.string.L31T5))
            }
            "Lección: 32 Rango vocales" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L32T1), resources.getString(R.string.L32T2))

            }
            "Lección: 33 Improvisación" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L33T1), resources.getString(R.string.L33T2), R.drawable.imagen76)
            }
            "Lección: 34 Progresiones de acordes" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L34T1), resources.getString(R.string.L34T2))
            }
            "Lección: 35 Re-armonización" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L35T1), resources.getString(R.string.L35T2), R.drawable.imagen75)
            }
            "Lección: 36 Composión: ideas generales y básicas" -> {
                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L36T1), resources.getString(R.string.L36T2))
            }



            else -> {
                throw Exception("Leccion no encontrada")
            }
        }


        viewManager = LinearLayoutManager(this.context)
        //Adapter recibe el metodo parte de la interfaz especificado por el fragmento
        viewAdapter = LeccionAdapter(dataSet)

        recyclerView = binding.recyclerViewLeccion?.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }!!

        return binding.root
    }

}
