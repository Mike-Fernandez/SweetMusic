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

//        binding.game = this

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
                    Question(text = resources.getString(R.string.E1P10), answers = listOf("Ut queant laxis", "Gigliola", "Jigolo Har Megiddo", "Ave María"), image = R.drawable.emagen1),
                    Question(text = resources.getString(R.string.E1P11), answers = listOf("Fa", "La", "Mi", "Si"), image = R.drawable.sweet_music_icon),
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
                    Question(text = resources.getString(R.string.E1P26), answers = listOf("3 corcheas", "2 corcheas", "4 corcheas", "5 corcheas"), image = R.drawable.emagen14),
                    Question(text = resources.getString(R.string.E1P27), answers = listOf("Tiene 5 tiempos y contamos a corcheas", "Tiene 8 tiempos y contamos a corcheas", "Tiene 5 tiempos y contamos a negras", "Tiene 8 tiempos y contamos a negras"), image = R.drawable.emagen14),
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
                    Question(text = resources.getString(R.string.E1P2), answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P27), answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P28), answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.sweet_music_icon),
                    Question(text = resources.getString(R.string.E1P29), answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.sweet_music_icon),
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
                numQuestions = 5

            }
            "Exámen de unidad 3" ->{
                var preguntas: MutableList<Question> = mutableListOf(
                    Question(text = resources.getString(R.string.E1P2), answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.imagen15),
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
                numQuestions = 5

            }
            "Exámen de unidad 4" ->{
                var preguntas: MutableList<Question> = mutableListOf(
                    Question(text = resources.getString(R.string.E1P2), answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.imagen15),
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
                numQuestions = 5

            }
            "Exámen de unidad 5" ->{
                var preguntas: MutableList<Question> = mutableListOf(
                    Question(text = resources.getString(R.string.E1P2), answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.imagen15),
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
                numQuestions = 5

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
//                        binding.invalidateAll()
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
        Log.d("Exam settingquestions", questions.toString())

        questionTv.text = currentQuestion.text

        if(currentQuestion.image == null){
            questionImage.visibility = View.INVISIBLE
        } else {
            Log.d("Examen image", questions[questionIndex].image.toString())
//            Log.d("Examen imageView", questionImage.toString())
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

