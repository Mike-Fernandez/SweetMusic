package com.programoviles.sweetmusic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.programoviles.sweetmusic.databinding.FragmentExamenBinding
import com.programoviles.sweetmusic.databinding.FragmentGlosarioBinding
import kotlinx.android.synthetic.main.fragment_examen.*
import kotlin.properties.Delegates


class ExamenFragment : Fragment() {

    data class Question(
        val text: String,
        val answers: List<String>,
        val image: Int
    )

    private var questions = mutableListOf<Question>()

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentExamenBinding>(inflater, R.layout.fragment_examen,
            container, false)

        var numQuestions: Int

        val args = arguments?.getString("unidad")

        when(args){
            "Exámen de unidad 1" ->{
                var preguntas: MutableList<Question> = mutableListOf(
                    Question(text = resources.getString(R.string.E1P1), answers = listOf("Alguien tocando guitarra", "Alarma de vehículo", "Claxon de una moto", "Perros ladrando "), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P2), answers = listOf("Sonoridad", "Duración", "Timbre", "Intenisidad"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P3), answers = listOf("Frecuencia fundamental", "Frecuencia baja", "Frecuencia armónica", "Frecuencia principal"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P4), answers = listOf("12", "7", "5", "10"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P5), answers = listOf("Guido D’Arezzo", "Aristóteles ", "Platón", "Papa Silvestre"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P6), answers = listOf("Pulso y tempo", "Tempo y velocidad", "Pulso y métrica", "Métrica y velocidad"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P7), answers = listOf("Es el enlace entre los sonidos que suena sucesivamente", "Conjunto de sonidos y silencios  ordenados los cuales son agradables al oído humano.", "Conjunto de sonidos y silencios  ordenados los cuales son agradables al oído humano.", "Indicador del color del sonido, así podemos diferenciar que instrumento suena"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P8), answers = listOf("E", "F", "G", "H"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P9), answers = listOf("Si", "Do", "Sol", "Re"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P10), answers = listOf("Ut queant laxis", "Gigliola", "Jigolo Har Megiddo", "Ave María"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P11), answers = listOf("Fa", "La", "Mi", "Si"), image = R.drawable.emagen1),
                    Question(text = resources.getString(R.string.E1P12), answers = listOf("Sib", "Sol", "La", "Re"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P13), answers = listOf("7 semitonos", "6 semitonos", "8 semitonos", "9 semitonos"), image = R.drawable.emagen2),
                    Question(text = resources.getString(R.string.E1P14), answers = listOf("Impropia", "Propia", "Accidente", "Precaución"), image = R.drawable.emagen3),
                    Question(text = resources.getString(R.string.E1P15), answers = listOf("Sol", "Fa en 3ra línea", "Do en 2d línea ", "Do en 5ta línea "), image = R.drawable.emagen4),
                    Question(text = resources.getString(R.string.E1P16), answers = listOf("La", "Fa", "Si", "Do"), image = R.drawable.emagen5),
                    Question(text = resources.getString(R.string.E1P17), answers = listOf("Diatonismo", "Pentatónico", "Cromatismo", "Dodecafónica"), image = R.drawable.emagen6),
                    Question(text = resources.getString(R.string.E1P18), answers = listOf("Sube un tono", "Sube un semitono", "Baja un semitono", "Baja un tono"), image = R.drawable.emagen7),
                    Question(text = resources.getString(R.string.E1P19), answers = listOf("Re#", "Sol#", "La#", "Fa#"), image = R.drawable.emagen8),
                    Question(text = resources.getString(R.string.E1P20), answers = listOf("Fa", "La", "Si", "Sol"), image = R.drawable.emagen9),
                    Question(text = resources.getString(R.string.E1P21), answers = listOf("Cromatismo", "Diatonismo", "Pentatónico", "Poli ritma "), image = R.drawable.emagen10),
                    Question(text = resources.getString(R.string.E1P22), answers = listOf("Sube un semitono", "Baja un semitono", "Sube un tono", "Baja un tono"), image = R.drawable.emagen11),
                    Question(text = resources.getString(R.string.E1P23), answers = listOf("Propia", "Impropia", "Accidente", "Precaución"), image = R.drawable.emagen12),
                    Question(text = resources.getString(R.string.E1P24), answers = listOf("Sol", "La", "Fa", "Si"), image = R.drawable.emagen13),
                    Question(text = resources.getString(R.string.E1P25), answers = listOf("Amalgama", "Simple binario", "Compuesto ternario", "Zorcico"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P27), answers = listOf("3 corcheas", "2 corcheas", "4 corcheas", "5 corcheas"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P26), answers = listOf("Tiene 7 tiempos y contamos a corcheas", "Tiene 8 tiempos y contamos a corcheas", "Tiene 5 tiempos y contamos a negras", "Tiene 8 tiempos y contamos a negras"), image = R.drawable.emagen14),
                    Question(text = resources.getString(R.string.E1P28), answers = listOf("Negra", "Blanca", "Redonda", "Fusa"), image = R.drawable.emagen19),
                    Question(text = resources.getString(R.string.E1P29), answers = listOf("1-8", "1-16", "1-32", "1-4"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P30), answers = listOf("Semicorchea", "Semifusa", "Corchea", "Blanca"), image = R.drawable.emagen15)
                )
                questions.addAll(preguntas)
                Log.d("Examen imageView", binding.questionImage.toString())
                questions = randomizeQuestions(
                    questions,
                    binding.questionTV,
                    binding.option1,
                    binding.option2,
                    binding.option3,
                    binding.option4,
                    binding.questionImage
                )
                numQuestions = 30

            }
            "Exámen de unidad 2" ->{
                var preguntas: MutableList<Question> = mutableListOf(
                    Question(text = resources.getString(R.string.E2P1), answers = listOf("Los que tienen numerador 2, 3 o 4", "Los que tienen numerador 1, 2 o 3", "Los que tienen numerador 1, 3 o 5", "Los que tienen numerador 1, 2 o 4"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P2), answers = listOf("Simple ternario", "Simple binario", "Simple cuartanario", "Simple de amalgama"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P3), answers = listOf("Simple cuartanario", "Simple ternario", "Simple binario", "Simple de amalgama"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P4), answers = listOf("Si", "No", "No del todo", "Casi siempre   "), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P5), answers = listOf("Compuesto binario", "Compuesto ternario", "Simple binario", "Simple ternario"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P6), answers = listOf("9/8", "7/4", "12/8", "5/4"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P7), answers = listOf("Compuesto cuartenario", "Compuesto Binario", "Compuesto Ternario", "Amalgama"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P8), answers = listOf("2/4", "3/ 4", "5/4", "4/4"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P9), answers = listOf("5/8", "6/8", "9/8", "12/8"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P10), answers = listOf("Fuerte-Débil-Débil-Semifuerte-Débil", "Fuerte-Débil-Débil-Débil-Semifuerte", "Fuerte-Débil-Semifuerte-Débil-Semifuerte", "Fuerte-Débil-Débil-Débil-Débil"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P11), answers = listOf("5+2", "2+3+2", "3+4", "6+1"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P12), answers = listOf("8/8", "15/8", "27/8", "21/8"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P13), answers = listOf("Fuerte-Débil-Semifuerte-Débil", "Fuerte-Débil-Débil-Semifuerte", "Fuerte-Débil-Débil-Débil", "Fuerte-Semifuerte-Débil-Débil"), image = R.drawable.emagen20),
                    Question(text = resources.getString(R.string.E2P14), answers = listOf("7/8", "5/4", "6/8", "6/8"), image = R.drawable.emagen14),
                    Question(text = resources.getString(R.string.E2P15), answers = listOf("F-D-D-SF-D-D-SF-D-D", "F-D-D-D-D-D-SF-D-D", "F-D-SF-SF-D-D-D-D-D", "F-D-SF-D-D-SF-D-D-D"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P16), answers = listOf("F-D-D-SF-D- SF-D-D-SF-D", "F-D-D-D- SF-D-SF-D-SF-D", "F-D-D-SF-D- SF-D-D-D-SF", "F-D-D-D-D- SF-D-D-SF-D"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P17), answers = listOf("12/8", "7/8", "5/8", "8/8"), image = R.drawable.emagen18),
                    Question(text = resources.getString(R.string.E2P18), answers = listOf("Casilla de repetición", "Barra repetición", "Coda", "D.C"), image = R.drawable.emagen23),
                    Question(text = resources.getString(R.string.E2P19), answers = listOf("Contratiempo", "Sincopa", "Poliritmia", "Amalgación"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P20), answers = listOf("Solo la primera vez", "Solo en la repetición", "No se repite", "No se toca"), image = R.drawable.emagen23),
                    Question(text = resources.getString(R.string.E2P21), answers = listOf("Tocar medio suave", "Tocar medio", "Muy suave", "Suave"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P22), answers = listOf("Acento", "Legato", "Pizzicato", "Stacato"), image = R.drawable.emagen24),
                    Question(text = resources.getString(R.string.E2P23), answers = listOf("Alegro", "Forte", "Piano", "Pianissimo"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P24), answers = listOf("Pizzicato", "Acento", "Legato", "Stacato"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E2P25), answers = listOf("Legato", "Acento", "Pizzicato", "Stacato"), image = R.drawable.emagen25),
                    Question(text = resources.getString(R.string.E2P26), answers = listOf("Piano Forte", "Mezzo Forte", "Forte piano", "Forte fortissimo"), image = R.drawable.sweet_music_icon)
                )
                questions.addAll(preguntas)
                Log.d("Examen imageView", binding.questionImage.toString())
                questions = randomizeQuestions(
                    questions,
                    binding.questionTV,
                    binding.option1,
                    binding.option2,
                    binding.option3,
                    binding.option4,
                    binding.questionImage
                )
                numQuestions = 26

            }
            "Exámen de unidad 3" ->{
                var preguntas= mutableListOf<Question>(
                    Question(text = resources.getString(R.string.E3P1), answers = listOf("Conjunto de sonidos que se tocan de manera ascendente o descendente", "Conjunto de acordes", "Tipo de acorde", "Tipo de triada    "), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P2), answers = listOf("Dominante", "Tónica", "Pivote", "Subdominante"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P3), answers = listOf("Re-mi-fa#-sol-la-si-do#", "Re-mi-fa-sol-la-si", "Re-mi-fa-sol-la-sib", "Re-mi-fa#-sol-la-si-do"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P4), answers = listOf("III", " I", "VII", "V"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P5), answers = listOf("Do mayor", "Si mayor", "Do menor", "Si menor"), image = R.drawable.emagen26),
                    Question(text = resources.getString(R.string.E3P6), answers = listOf("T-T-ST-T-T-T-ST", "T-T-T-ST-T-ST-T", "T-ST-T-T-T-ST-T", "T-T-ST-T-T-ST-T"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P7), answers = listOf("Disminuido", "Mayor", "Menor", "Aumentado), image = R.drawable.sweet_music_icon"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P8), answers = listOf("Si", "La", "Sol", "Fa"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P9), answers = listOf("Mayor", "Menor", "Disminuido", "Aumentado"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P10), answers = listOf("VII", "III", "II", "IV"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P11), answers = listOf("T-ST-T-T-ST-T-T", "ST-T-T-T-ST-T-T", "ST-T-T-ST-T-T-T", "T-ST-T-T-T-ST-T"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P12), answers = listOf("Mayor", "Menor", "Aumentado", "Disminuido"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P13), answers = listOf("Sol-la-sib-do-re-mib-fa", "Sol-la-si-do#-re-mi-fa#  ", "Sol-lab- sib-do-re-mib-fa", "Sol-lab- sib-do-reb-mib-fa"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P14), answers = listOf("Mi menor", "Sib menor", "La menor", "Fa# menor"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P15), answers = listOf("Mi mayor/ Do# menor", "La mayor/ Fa# menor", "Re# mayor/ Do menor", "Fa mayor/ Re menor"), image = R.drawable.emagen27),
                    Question(text = resources.getString(R.string.E3P16), answers = listOf("Do-Re-Mib-Fa-Sol-Lab-Sib", "Do-Re#-Mi-Fa-Sol-La#-Si", "Do-Reb-Mi-Fa-Solb-La-Lab", "Do-Re-Mi-Fa#-Sol-La-Si"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P17), answers = listOf("Sensible", "Aumentado", "Subtonica", "Disminuido"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P18), answers = listOf("Si-Do#-Re-Mi-Fa#-Sol-La#", "Si-Do#-Re-Mi-Fa-Sol-La", "Si-Do-Re#-Mi-Fa-Sol-La", "Si-Do#-Re-Mi-Fa-Sol-La#"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P19), answers = listOf("La-Si-Do-Re-Mi-Fa#-Sol#", "La-Si-Do-Re-Mi-Fa-Sol#", "La-Si-Do#-Re-Mi-Fa-Sol", "La-Si-Do-Re#-Mi-Fa#-Sol#"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P20), answers = listOf("Subdominante y Sensible", "Dominante y Subtónica ", "Mediante y Sensible", "Super tónica y Super dominante"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P21), answers = listOf("Super Tónica y Super dominante", "Super Tónica y Sub tónica", "Mediante y Super dominante", "Super Tónica y Dominante"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P22), answers = listOf("Do -Mib-Fa-Sol- La#", "Do-Re-Fa-Sol-Sol#", "Do-Re -Mib-Fa- La#", "Do -Mib-Fa-Sol#- La#"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P23), answers = listOf("Re-Mi-Fa-Sol-La-Sib-Do", "La-Si-Do-Re-Mi-Fa-Sol#", "Do-Re-Mib-Fa-Sol-Sol#-Si", "Fa-Sol-Lab-Sib-Do-Reb-Mi"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P24), answers = listOf("Re-Mi-Fa-Sol-La-Sib-Do", "La-Si-Do-Re-Mi-Fa#-Sol#", "Do-Re-Mib-Fa-Sol-La-Si", "Fa-Sol-Lab-Sib-Do-Re-Mi"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E3P25), answers = listOf("Sol-La-Si-Re-Mi", "Sol-Si-Do-Re-Fa#", "Sol-Si-Do-Mi-Fa#", "Sol-La-Do-Re-Mi"), image = R.drawable.sweet_music_icon)

                )
                questions.addAll(preguntas)
                Log.d("Examen imageView", binding.questionImage.toString())
                questions = randomizeQuestions(
                    questions,
                    binding.questionTV,
                    binding.option1,
                    binding.option2,
                    binding.option3,
                    binding.option4,
                    binding.questionImage
                )
                numQuestions = 25

            }
            "Exámen de unidad 4" ->{
                var preguntas: MutableList<Question> = mutableListOf(
                    Question(text = resources.getString(R.string.E4P1), answers = listOf("5ta justa", "5ta aumentada", "5ta disminuida", "4ta aumentada"), image = R.drawable.emagen28),
                    Question(text = resources.getString(R.string.E4P2), answers = listOf("3ra menor", "3ra mayor", "3ra aumentada", "3ra disminuida"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E4P3), answers = listOf("8va justa", "8va aumentada", "8va disminuida", "8va mayor"), image = R.drawable.emagen29),
                    Question(text = resources.getString(R.string.E4P4), answers = listOf("7ma menor", "7ma mayor", "7ma aumentada", "7ma disminuida"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E4P5), answers = listOf("7ma menor", "6ta mayor", "7ma mayor", "6ta menor"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E4P6), answers = listOf("4 tonos y medio", "4 tonos", "5 tonos", "5 tonos y medio"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E4P7), answers = listOf("4 tonos", "5 tonos", "5 tonos y medio", "4 tonos y medio"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E4P8), answers = listOf("3ra menor", "2da mayor", "4 disminuida", "3ra mayor"), image = R.drawable.emagen30),
                    Question(text = resources.getString(R.string.E4P9), answers = listOf("Justa", "Mayor", "Mayor", "Aumentada"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E4P10), answers = listOf("Re-Fa#-La", "Justa ", "Si-Re-Fa", "Mi-Sol-Si"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E4P11), answers = listOf("Em", "E", "E aug", "E dim"), image = R.drawable.emagen31),
                    Question(text = resources.getString(R.string.E4P12), answers = listOf("G aug", "G", "Gm", "G dim"), image = R.drawable.emagen32),
                    Question(text = resources.getString(R.string.E4P13), answers = listOf("A dim", "A", "Am", "A aug"), image = R.drawable.emagen33),
                    Question(text = resources.getString(R.string.E4P14), answers = listOf("1ra inversión", "Fundamental", "2da inversión", "3ra inversión"), image = R.drawable.emagen34),
                    Question(text = resources.getString(R.string.E4P15), answers = listOf("2da inversión", "Fundamental", "1ra inversión", "3ra inversión"), image = R.drawable.emagen35),
                    Question(text = resources.getString(R.string.E4P16), answers = listOf("G7", "Gmaj7", "Gm maj7", "Gm7"), image = R.drawable.emagen36),
                    Question(text = resources.getString(R.string.E4P17), answers = listOf("Fmaj7", "F7", "Fm maj7", "Fm7"), image = R.drawable.emagen37),
                    Question(text = resources.getString(R.string.E4P18), answers = listOf("A-B-E", "C-F-G", "G-C-D", "D-E-A"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E4P19), answers = listOf("B-D-F#", "E-F#-B", "C#-D#-G#", "A-B-E"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E4P20), answers = listOf("Cadd2", "Cmaj7", "C7", "Cadd4"), image = R.drawable.emagen34),
                    Question(text = resources.getString(R.string.E4P21), answers = listOf("2da inversión", "Fundamental", "1er inversión ", "3ra inversión"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E4P22), answers = listOf("A-E-A", "A-D-A", "A-E-G", "A-D-E"), image = R.drawable.sweet_music_icon)

                )
                questions.addAll(preguntas)
                Log.d("Examen imageView", binding.questionImage.toString())
                questions = randomizeQuestions(
                    questions,
                    binding.questionTV,
                    binding.option1,
                    binding.option2,
                    binding.option3,
                    binding.option4,
                    binding.questionImage
                )
                numQuestions = 22

            }
            "Exámen de unidad 5" ->{
                var preguntas: MutableList<Question> = mutableListOf(
                    Question(text = resources.getString(R.string.E5P1), answers = listOf("Dórico", "Jónico", "Mixolidio", "Lidio"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P2), answers = listOf("M-M-m-d-M-m-m", "M-M-m-m-M-d-m", "M-m-M-d-m-M-m", "M-M-m-d-M-m-M"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P3), answers = listOf("M-M-m-d-M-m-m", "M-M-m-d-M-m-m", "M-M-m-d-M-m-m", "M-M-m-d-M-m-m"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P4), answers = listOf("IV", "V", "VII", "IV"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P5), answers = listOf("A-Bb-C-D-E-F-G", "A-Bb-C-D-E-F-G", "A-Bb-C-D-E-F-G", "A-Bb-C-D-E-F-G"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P6), answers = listOf("M-m-d-M-m-M-M", "M-M-m-d-M-m-m", "M-m-M-d-m-M-m", "M-M-m-m-M-d-m"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P7), answers = listOf("VII", "V", "IV", "III"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P8), answers = listOf("F-G-A-Bb-C-D-E", "F-G-A-B-Cb-D-E", "F-G-Ab-C-D-E", "F-G-Ab-Bb-C-D-E"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P9), answers = listOf("Locrio", "Eólico", "Frigio", "Dórico"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P10), answers = listOf("A-Bb-C-D-Eb-F-G", "A-Bb-C-D-E-F-G", "A-B-C-D-Eb-F-G", "A-B-C-D-E-F-G"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P11), answers = listOf("VI", "V", "IV", "III"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P12), answers = listOf("m-M-M-m-d-M-m", "M-M-m-m-M-d-m", "M-m-M-d-m-M-m", "M-M-m-d-M-m-m"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P13), answers = listOf("V", "VI", "IV", "III"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P14), answers = listOf("F#-G-A-B-C-D-E", "F#-G-A-B-C-D#-E", "F#-G#-A#-C-D#-E", "F#-G-A#-B-C#-D#-E"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P15), answers = listOf("m-m-M-M-m-d-M", "M-M-m-m-M-d-m", "M-m-M-d-m-M-m", "M-M-m-d-M-m-m"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P16), answers = listOf("IV", "V", "VI", "VII"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P17), answers = listOf("VII", "V", "VI", "IV"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P18), answers = listOf("V", "IV", "VI", "III"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E5P19), answers = listOf("C-D-D#-E-G-A", "A-C-D-D#-E-G", "B-D-E-F-F#-A", "F-G#-A#-B-C-E"), image = R.drawable.sweet_music_icon)
                )
                questions.addAll(preguntas)
                Log.d("Examen imageView", binding.questionImage.toString())
                questions = randomizeQuestions(
                    questions,
                    binding.questionTV,
                    binding.option1,
                    binding.option2,
                    binding.option3,
                    binding.option4,
                    binding.questionImage
                )
                numQuestions = 19

            }
            else -> throw Exception()
        }
        binding.answerButton.setOnClickListener { view: View ->
            val checkId = binding.questionRadioGroup.checkedRadioButtonId

            if (-1 != checkId) {
                var answerIndex = 0
                when (checkId) {
                    R.id.option2 -> answerIndex = 1
                    R.id.option3 -> answerIndex = 2
                    R.id.option4 -> answerIndex = 3
                }

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++

                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion(questions,
                            binding.questionTV,
                            binding.option1,
                            binding.option2,
                            binding.option3,
                            binding.option4,
                            binding.questionImage
                        )
                        binding.questionRadioGroup.clearCheck()
                    } else {
                        view.findNavController()
                            .navigate(R.id.action_examenFragment_to_passedExamFragment)
                    }
                } else {
                    view.findNavController()
                        .navigate(R.id.action_examenFragment_to_intentoFallidoFragment)
                }
            }
        }


        return binding.root
    }

    private fun randomizeQuestions(
        questions: MutableList<ExamenFragment.Question>,
        questionTV: TextView,
        option1: RadioButton,
        option2: RadioButton,
        option3: RadioButton,
        option4: RadioButton,
        questionImage: ImageView
    ): MutableList<ExamenFragment.Question> {
        questions.shuffle()
        questionIndex = 0
        setQuestion(questions, questionTV, option1, option2, option3, option4, questionImage)

        return questions
    }

    private fun setQuestion(
        questions: MutableList<ExamenFragment.Question>,
        questionTv: TextView,
        option1: RadioButton,
        option2: RadioButton,
        option3: RadioButton,
        option4: RadioButton,
        questionImage: ImageView
    ) {
        currentQuestion = questions[questionIndex]

        questionTv.text = currentQuestion.text

        if(currentQuestion.image == null){
            questionImage.visibility = View.INVISIBLE
        } else {
            questionImage.setImageResource(currentQuestion.image)
            questionImage.visibility = View.VISIBLE
        }

        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        option1.text = answers[0]
        option2.text = answers[1]
        option3.text = answers[2]
        option4.text = answers[3]
    }
}

