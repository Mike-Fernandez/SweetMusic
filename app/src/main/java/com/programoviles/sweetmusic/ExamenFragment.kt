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
                    Question(text = "Pregunta 1", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.imagen15),
                    Question(text = "Pregunta 2", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.dism),
                    Question(text = "Pregunta 3", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.arti),
                    Question(text = "Pregunta 4", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.imagen1),
                    Question(text = "Pregunta 5", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.sincopa),
                    Question(text = "Pregunta 6", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.aumentada7),
                    Question(text = "Pregunta 7", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.imagen15),
                    Question(text = "Pregunta 8", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"), image = R.drawable.imagen10)
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

