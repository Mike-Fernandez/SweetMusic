package com.programoviles.sweetmusic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
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
    private lateinit var dataSet2: ArrayList<Any>
    private lateinit var dataSet: Leccion
//    private lateinit var dataSet: Array<Map<String, String>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentBloqueLeccionBinding>(inflater, R.layout.fragment_bloque_leccion,
            container, false)

        Log.d("Arguments for Lesson", arguments?.getString("lesson"))

        when(arguments?.getString("lesson")){
            "Lección: 1 El sonido" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3, 2,0,1), arrayOf(resources.getString(R.string.L1T2)), arrayOf(R.drawable.imagen1), arrayOf(resources.getString(R.string.L1T1)))
//                dataSet = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L1T1), resources.getString(R.string.L1T2), R.drawable.imagen1)
            }
            "Lección: 2 Propiedades del sonido"-> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,0,1,0), arrayOf(resources.getString(R.string.L2T2), resources.getString(R.string.L2T3), "imagen de ecualizador gráfico"), arrayOf(R.drawable.imagen2, R.drawable.imagen3), arrayOf(resources.getString(R.string.L2T1)))
            }
            "Lección: 3 Introducción a la música" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,2,0,2,1,0,1),arrayOf(resources.getString(R.string.L3T2), resources.getString(R.string.L3T4),resources.getString(R.string.L3T6)), arrayOf(R.drawable.imagen4, R.drawable.imagen6, R.drawable.imagen8), arrayOf(resources.getString(R.string.L3T1), resources.getString(R.string.L3T3), resources.getString(R.string.L3T5)))
            }
            "Lección: 4 Introducción a la música(Continuación)" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,0,1), arrayOf(resources.getString(R.string.L4T2), resources.getString(R.string.L4T4)), arrayOf(R.drawable.imagen9, R.drawable.imagen10), arrayOf(resources.getString(R.string.L4T1), resources.getString(R.string.L4T3)))
            }
            "Lección: 5 Alteraciones y Diatonismo vs cromatismo" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,0,1,0,1,0,0), arrayOf(resources.getString(R.string.L5T2), resources.getString(R.string.L5T3), resources.getString(R.string.L5T4), resources.getString(R.string.L5T5), resources.getString(R.string.L5T6)), arrayOf(R.drawable.imagen11, R.drawable.imagen12, R.drawable.imagen13), arrayOf(resources.getString(R.string.L5T1)))
            }
            "Lección: 6 Introducción a la lectura musical (Claves y notas)" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,2,0,1,0,1,2,0,1,0,1), arrayOf(resources.getString(R.string.L6T2), resources.getString(R.string.L6T4), resources.getString(R.string.L6T5), resources.getString(R.string.L6T7), resources.getString(R.string.L6T8)), arrayOf(R.drawable.imagen14, R.drawable.imagen15, R.drawable.imagen16, R.drawable.imagen17, R.drawable.imagen18), arrayOf(resources.getString(R.string.L6T1), resources.getString(R.string.L6T3), resources.getString(R.string.L6T6)))
            }
            "Lección: 7 Lectura musical I" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,2,0,1,2,0,1,2,0,1), arrayOf(resources.getString(R.string.L7T2), resources.getString(R.string.L7T4), resources.getString(R.string.L7T6),resources.getString(R.string.L7T8)), arrayOf(R.drawable.imagen19, R.drawable.imagen20, R.drawable.metro), arrayOf(resources.getString(R.string.L7T1), resources.getString(R.string.L7T3), resources.getString(R.string.L7T5), resources.getString(R.string.L7T7)))
            }
            "Lección: 8 Lectura musical II" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,0,2,0,1,0,1,2,0,1), arrayOf(resources.getString(R.string.L8T2), resources.getString(R.string.L8T3), resources.getString(R.string.L8T5), resources.getString(R.string.L8T6), resources.getString(R.string.L8T8)), arrayOf(R.drawable.imagen21, R.drawable.imagen22, R.drawable.imagen23, R.drawable.ligadura), arrayOf(resources.getString(R.string.L8T1), resources.getString(R.string.L8T4), resources.getString(R.string.L8T7)))
            }
            "Lección: 9 Lectura musical III" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1), arrayOf(resources.getString(R.string.L9T2)), arrayOf(R.drawable.imagen24), arrayOf(resources.getString(R.string.L9T1)))
            }
            "Lección: 10 Teoría rítmica I" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,2,0,1), arrayOf(resources.getString(R.string.L10T2), resources.getString(R.string.L10T4)), arrayOf(R.drawable.imagen25, R.drawable.imagen26), arrayOf(resources.getString(R.string.L10T1), resources.getString(R.string.L10T3)))
            }
            "Lección: 11 Teoría rítmica II" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,2,0,1,0), arrayOf(resources.getString(R.string.L11T2), resources.getString(R.string.L11T4), resources.getString(R.string.L11T5)), arrayOf(R.drawable.imagen27, R.drawable.imagen28), arrayOf(resources.getString(R.string.L11T1), resources.getString(R.string.L11T3)))
            }
            "Lección: 12 Sincopa vs contratiempo" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,2,0,1), arrayOf(resources.getString(R.string.L12T2), resources.getString(R.string.L12T4)), arrayOf(R.drawable.sincopa, R.drawable.contra), arrayOf(resources.getString(R.string.L12T1), resources.getString(R.string.L12T3)))
                dataSet2 = arrayListOf<Any>("*" + arguments?.getString("lesson")!!, resources.getString(R.string.L12T1), resources.getString(R.string.L12T2), R.drawable.sincopa, resources.getString(R.string.L12T3), R.drawable.contra)
            }
            "Lección: 13 Signos de repetición, dinámicas y artículaciones" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,0,1,0,1,0,2,0,1,2,0,1), arrayOf(resources.getString(R.string.L13T2),resources.getString(R.string.L13T3),resources.getString(R.string.L13T4),resources.getString(R.string.L13T5),resources.getString(R.string.L13T7),resources.getString(R.string.L13T9)), arrayOf(R.drawable.imagen29,R.drawable.imagen30,R.drawable.imagen31,R.drawable.dinamica,R.drawable.arti), arrayOf(resources.getString(R.string.L13T1),resources.getString(R.string.L13T6),resources.getString(R.string.L13T8)))
            }
            "Lección: 14 Introducción a las escalas" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3,2,0,1,2,0), arrayOf(resources.getString(R.string.L14T2),resources.getString(R.string.L14T4)), arrayOf(R.drawable.grados), arrayOf(resources.getString(R.string.L14T1),resources.getString(R.string.L14T3)))
            }
            "Lección: 15 Escala Mayor Natural" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3,2,0,2,0,1,0), arrayOf(resources.getString(R.string.L15T2),resources.getString(R.string.L15T4),resources.getString(R.string.L15T5)),arrayOf(R.drawable.imagen32,R.drawable.imagen33),arrayOf(resources.getString(R.string.L15T1),resources.getString(R.string.L15T3)))
            }
            "Lección: 16 Escala Menor Natural" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3,2,0,2,0,1), arrayOf(resources.getString(R.string.L16T2),resources.getString(R.string.L16T4)),arrayOf(R.drawable.imagen34),arrayOf(resources.getString(R.string.L16T1),resources.getString(R.string.L16T3)))
            }
            "Lección: 17 Tonalidades" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3,2,0,1,0,2,0,1,0,1,2,0), arrayOf(resources.getString(R.string.L17T2),resources.getString(R.string.L17T3),resources.getString(R.string.L17T5),resources.getString(R.string.L17T6),resources.getString(R.string.L17T8)),arrayOf(R.drawable.imagen35,R.drawable.imagen36,R.drawable.imagen37),arrayOf(resources.getString(R.string.L17T1),resources.getString(R.string.L17T4),resources.getString(R.string.L17T7)))
            }
            "Lección: 18 Escala Pentatónica y armónica" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3,2,0,2,0,1,2,2,0,1,2,0,1), arrayOf(resources.getString(R.string.L18T2),resources.getString(R.string.L18T4),resources.getString(R.string.L18T7),resources.getString(R.string.L18T9)),arrayOf(R.drawable.imagen38,R.drawable.imagen39,R.drawable.imagen40),arrayOf(resources.getString(R.string.L18T1),resources.getString(R.string.L18T3),resources.getString(R.string.L18T5),resources.getString(R.string.L18T6),resources.getString(R.string.L18T8)))
            }
            "Lección: 19 Escala menor bachiana, menor melódica y cromática" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3,2,0,1,2,0,1,2,0,1,2), arrayOf(resources.getString(R.string.L19T2),resources.getString(R.string.L19T4),resources.getString(R.string.L19T6)),arrayOf(R.drawable.imagen41,R.drawable.imagen42,R.drawable.imagen43),arrayOf(resources.getString(R.string.L19T1),resources.getString(R.string.L19T3),resources.getString(R.string.L19T5),resources.getString(R.string.L19T7)))
            }
            "Lección: 20 Intervalos" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3,2,0,1,0,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1), arrayOf(resources.getString(R.string.L20T2),resources.getString(R.string.L20T3),resources.getString(R.string.L20T5),resources.getString(R.string.L20T7),resources.getString(R.string.L20T9),resources.getString(R.string.L20T11),resources.getString(R.string.L20T13),resources.getString(R.string.L20T15),resources.getString(R.string.L20T17),resources.getString(R.string.L20T19),resources.getString(R.string.L20T21)),arrayOf(R.drawable.imagen44,R.drawable.imagen45,R.drawable.imagen46,R.drawable.imagen47,R.drawable.imagen48,R.drawable.imagen49,R.drawable.imagen50,R.drawable.imagen51,R.drawable.imagen52,R.drawable.imagen53),arrayOf(resources.getString(R.string.L20T1),resources.getString(R.string.L20T4),resources.getString(R.string.L20T6),resources.getString(R.string.L20T8),resources.getString(R.string.L20T10),resources.getString(R.string.L20T12),resources.getString(R.string.L20T14),resources.getString(R.string.L20T16),resources.getString(R.string.L20T18),resources.getString(R.string.L20T20)))
            }
            "Lección: 21 Intervalos II" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3, 2, 0, 1, 0, 2, 0, 0, 0, 0, 2, 0, 1, 0), arrayOf(resources.getString(R.string.L21T2), resources.getString(R.string.L21T3), resources.getString(R.string.L21T5), resources.getString(R.string.L21T6), resources.getString(R.string.L21T7), resources.getString(R.string.L21T8), resources.getString(R.string.L21T10), resources.getString(R.string.L21T11)), arrayOf(R.drawable.imagen54, R.drawable.imagen55), arrayOf(resources.getString(R.string.L21T1), resources.getString(R.string.L21T4), resources.getString(R.string.L21T9)))            }
            "Lección: 22 Acordes I" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3, 2, 0, 2, 0, 0, 1, 0, 0, 1, 0), arrayOf(resources.getString(R.string.L22T2), resources.getString(R.string.L22T4), resources.getString(R.string.L22T5),"Un acorde D",resources.getString(R.string.L22T6), "Un acorde Gm7" ), arrayOf(R.drawable.imagen56, R.drawable.imagen57), arrayOf(resources.getString(R.string.L22T1), resources.getString(R.string.L22T3)))
            }
            "Lección: 23 Acordes II" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3, 0, 1, 0, 0, 1, 0, 2, 0, 1, 2, 0), arrayOf(resources.getString(R.string.L23T1), "Acorde C aug", resources.getString(R.string.L23T2), "Acorde B dim",resources.getString(R.string.L23T4), resources.getString(R.string.L23T6)), arrayOf(R.drawable.imagen58, R.drawable.imagen59), arrayOf(resources.getString(R.string.L23T3), resources.getString(R.string.L23T5)))
            }
            "Lección: 24 Acordes III" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3, 2, 0, 1, 2, 0, 1, 2, 0, 1, 0), arrayOf(resources.getString(R.string.L24T2), resources.getString(R.string.L24T4), resources.getString(R.string.L24T6), "Acorde C add2"), arrayOf(R.drawable.imagen61, R.drawable.imagen62, R.drawable.imagen63), arrayOf(resources.getString(R.string.L24T1), resources.getString(R.string.L24T3), resources.getString(R.string.L24T5)))
            }
            "Lección: 25 Acordes IV" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0), arrayOf(resources.getString(R.string.L25T2), resources.getString(R.string.L25T3), "Acorde C Maj7", resources.getString(R.string.L25T4), "Acorde G7", resources.getString(R.string.L25T5), resources.getString(R.string.L25T6), resources.getString(R.string.L25T7)), arrayOf(R.drawable.imagen64, R.drawable.imagen65, R.drawable.imagen66), arrayOf(resources.getString(R.string.L25T1)))
            }
            "Lección: 26 Acordes V" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3, 0, 0, 1, 0, 2, 0, 1, 0, 2, 0, 1, 0), arrayOf(resources.getString(R.string.L26T1), resources.getString(R.string.L26T2), "Acorde B° maj7", resources.getString(R.string.L26T4), "Acorde A# add9", resources.getString(R.string.L26T6), "Ejemplos de inversiones"), arrayOf(R.drawable.imagen67, R.drawable.imagen68, R.drawable.imagen69), arrayOf(resources.getString(R.string.L26T3), resources.getString(R.string.L26T5)))
            }
            "Lección: 27 Introducción a las escalas modales" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3, 2, 0, 1, 0, 1), arrayOf(resources.getString(R.string.L27T2), resources.getString(R.string.L27T3)), arrayOf(R.drawable.imagen70, R.drawable.imagen71), arrayOf(resources.getString(R.string.L27T1)))
            }
            "Lección: 28 Modos mayores" -> {
                dataSet = Leccion(arguments?.getString("lesson")!! , arrayOf(3, 2, 0, 2, 0, 2, 0), arrayOf(resources.getString(R.string.L28T2), resources.getString(R.string.L28T4), resources.getString(R.string.L28T6)), arrayOf(R.drawable.imagen1), arrayOf(resources.getString(R.string.L28T1), resources.getString(R.string.L28T3), resources.getString(R.string.L28T5)))

            }
            "Lección: 29 Modos menores" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,2,0,2,0,2,0), arrayOf(resources.getString(R.string.L29T2),resources.getString(R.string.L29T4),resources.getString(R.string.L29T6),resources.getString(R.string.L29T8)), arrayOf(R.drawable.imagen2), arrayOf(resources.getString(R.string.L29T1),resources.getString(R.string.L29T3),resources.getString(R.string.L29T5),resources.getString(R.string.L29T7))
                    //resources.getString(R.string.L29T1), resources.getString(R.string.L29T2),resources.getString(R.string.L29T3), resources.getString(R.string.L29T4), resources.getString(R.string.L29T5), resources.getString(R.string.L29T6), resources.getString(R.string.L29T7), resources.getString(R.string.L29T8)
                )
            }
            "Lección: 30 Otras escalas I" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1,2,0,2,0,2,0,2,0),arrayOf(resources.getString(R.string.L30T2),resources.getString(R.string.L30T4),resources.getString(R.string.L30T6),resources.getString(R.string.L30T8),resources.getString(R.string.L30T10)),arrayOf(R.drawable.imagen72), arrayOf(resources.getString(R.string.L30T1),resources.getString(R.string.L30T3),resources.getString(R.string.L30T5),resources.getString(R.string.L30T7),resources.getString(R.string.L30T9))
                    //resources.getString(R.string.L30T1), resources.getString(R.string.L30T2), R.drawable.imagen72, resources.getString(R.string.L30T3), resources.getString(R.string.L30T4),resources.getString(R.string.L30T5), resources.getString(R.string.L30T6), resources.getString(R.string.L30T7), resources.getString(R.string.L30T8), resources.getString(R.string.L30T9), resources.getString(R.string.L30T10)
                )
            }
            "Lección: 31 Otras escalas II" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,2,0,1,0),arrayOf(resources.getString(R.string.L31T2),resources.getString(R.string.L31T4),resources.getString(R.string.L31T5)),arrayOf(R.drawable.imagen73),arrayOf(resources.getString(R.string.L31T1),resources.getString(R.string.L31T3))
                    //resources.getString(R.string.L31T1), resources.getString(R.string.L31T2),resources.getString(R.string.L31T3), resources.getString(R.string.L31T4), R.drawable.imagen73, resources.getString(R.string.L31T5)
                )
            }
            "Lección: 32 Rango vocales" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0),arrayOf(resources.getString(R.string.L32T2)),arrayOf(R.drawable.imagen2),arrayOf(resources.getString(R.string.L32T1))
                    //resources.getString(R.string.L32T1), resources.getString(R.string.L32T2)
                )

            }
            "Lección: 33 Improvisación" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1), arrayOf(resources.getString(R.string.L33T2)),arrayOf(R.drawable.imagen76),arrayOf(resources.getString(R.string.L33T1))
                    // resources.getString(R.string.L33T1), resources.getString(R.string.L33T2), R.drawable.imagen76
                )
            }
            "Lección: 34 Progresiones de acordes" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0), arrayOf(resources.getString(R.string.L34T2)),arrayOf(R.drawable.imagen76),arrayOf(resources.getString(R.string.L34T1))
                    //resources.getString(R.string.L34T1), resources.getString(R.string.L34T2)
                )
            }
            "Lección: 35 Re-armonización" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!, arrayOf(3,2,0,1),arrayOf(resources.getString(R.string.L35T2)),arrayOf(R.drawable.imagen75),arrayOf(resources.getString(R.string.L35T1))
                    //resources.getString(R.string.L35T1), resources.getString(R.string.L35T2), R.drawable.imagen75
                )
            }
            "Lección: 36 Composión: ideas generales y básicas" -> {
                dataSet = Leccion(arguments?.getString("lesson")!!,arrayOf(3,2,0) ,arrayOf(resources.getString(R.string.L36T2)),arrayOf(R.drawable.imagen75),arrayOf(resources.getString(R.string.L36T1))
                    // resources.getString(R.string.L36T1), resources.getString(R.string.L36T2)
                )
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

        binding.toolbarLesson.setOnNavigationItemReselectedListener{
            when(it.itemId){
                R.id.glosario_access -> this.findNavController().navigate(R.id.action_bloqueLeccion_to_glosarioFragment)
                R.id.metronomo_access -> this.findNavController().navigate(R.id.action_bloqueLeccion_to_metronomo)
                R.id.chord_access -> this.findNavController().navigate(R.id.action_bloqueLeccion_to_acordesFragment)
                R.id.afinador_access -> this.findNavController().navigate(R.id.action_bloqueLeccion_to_afinador)
            }
        }

        return binding.root
    }

}
