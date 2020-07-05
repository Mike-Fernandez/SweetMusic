package com.programoviles.sweetmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.programoviles.sweetmusic.databinding.FragmentExamenBinding
import com.programoviles.sweetmusic.databinding.FragmentGlosarioBinding
import kotlin.properties.Delegates


class ExamenFragment : Fragment() {

    data class Question(
        val text: String,
        val answers: List<String>
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

        binding.game = this

        val args = arguments?.getString("unidad")

        when(args){
            "Exámen de unidad 1" ->{
                var preguntas: MutableList<Question> = mutableListOf(
                    Question(text = "Pregunta 1", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3")),
                    Question(text = "Pregunta 2", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3")),
                    Question(text = "Pregunta 3", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3")),
                    Question(text = "Pregunta 4", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3")),
                    Question(text = "Pregunta 5", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3")),
                    Question(text = "Pregunta 6", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3")),
                    Question(text = "Pregunta 7", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3")),
                    Question(text = "Pregunta 8", answers = listOf("Buena", "Mal 1", "Mal 2", "Mal 3"))
                )
                questions.addAll(preguntas)
                questions = randomizeQuestions(questions)
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
                        questions = setQuestion(questions)
                        binding.questionRadioGroup.clearCheck()
                        binding.invalidateAll()
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

    private fun randomizeQuestions(questions: MutableList<ExamenFragment.Question>): MutableList<ExamenFragment.Question> {
        questions.shuffle()
        questionIndex = 0
        setQuestion(questions)

        return questions
    }

    private fun setQuestion(questions: MutableList<ExamenFragment.Question>): MutableList<ExamenFragment.Question> {
        currentQuestion = questions[questionIndex]

        answers = currentQuestion.answers.toMutableList()

        answers.shuffle()
        return questions

    }
}

