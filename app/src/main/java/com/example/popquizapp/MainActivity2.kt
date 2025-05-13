package com.example.popquizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var questionTxt: TextView
    private lateinit var statementTxt: TextView
    private lateinit var trueBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var falseBtn: Button
    private lateinit var selectedQuestionSet: QuestionSet


    enum class QuestionSetIdentifier {
        SET_ONE,
        SET_TWO,
        SET_THREE,
        SET_FOUR,
        SET_FIVE
    }
    data class QuestionSet(
        val id: QuestionSetIdentifier,
        val questions: ArrayList<String>,
        val answers: ArrayList<Boolean>
    )

    companion object {
        val questionSets = listOf(
            /*1st SET of questions*/
            QuestionSet(
                QuestionSetIdentifier.SET_ONE,
                arrayListOf(
                    " The star sign Aquarius is represented by a tiger",
                    " 'A' is the most common letter used in the English language ",
                    " ASOS stands for As Seen On Screen",
                    " The Battle Of Hastings took place in 1066",
                    " H&M stands for Hennes & Mauritz",
                    " K is worth four points in Scrabble",
                    " In a deck of cards, the king has a moustache",
                    " When the two numbers on opposite sides of a dice are added together it always equals 7",
                    " In the English language there is no word that rhymes with orange",
                    " English is the most spoken language in the world"
                ),
                arrayListOf(false, false, true, true, true, true, false, true, true, false)
            ),

            /*2nd SET of questions*/
            QuestionSet(
                QuestionSetIdentifier.SET_TWO,
                arrayListOf(
                    "The unicorn is the national animal of Scotland",
                    "A cross between a horse and a zebra is called a 'Hobra'",
                    "A lion's roar can be heard up to eight kilometres away",
                    "Canis lupur is the scientific name for a wolf",
                    "An octopus has three hearts",
                    "Fish cannot blink",
                    "Goldfish have a two second memory",
                    "In Finding Nemo the protagonist is a pufferfish",
                    "Hippos sweat a red substance",
                    "The first animal sent into space was a monkey"
                ),
                arrayListOf(true, false, true, false, true, true, false, false, true, false)
            ),

            /*3rd SET of questions*/
            QuestionSet(
                QuestionSetIdentifier.SET_THREE,
                arrayListOf(
                    "The atomic number for lithium is 17",
                    "The black box in a plane is black",
                    "Alexander Fleming discovered penicillin",
                    "There are two parts of the body that can't heal themselves",
                    "There are five different blood groups",
                    "Your 'radius' bone is in your leg",
                    "The only letter not in the periodic table is the letter J",
                    "The small intestine is about three-and-a-half times the length of your body",
                    "Thomas Edison discovered gravity",
                    "Venus is the hottest planet in the solar system"
                ),
                arrayListOf(false, false, true, false, false, false, true, true, false, true)
            ),

            /*4th SET of questions*/
            QuestionSet(
                QuestionSetIdentifier.SET_FOUR,
                arrayListOf(
                    "Marrakesh is the capital of Morocco",
                    "Waterloo has the greatest number of tube platforms in London",
                    "The Great Wall of China is longer than the distance between London and Beijing",
                    "Monaco is the smallest country in the world",
                    "The river Seine in Paris is longer than the river Thames in London",
                    "Alaska is the biggest American state in square miles",
                    "Australia is wider than the moon",
                    "The United States has the longest coastline in the world",
                    "Peru shares a border with Venezuela",
                    "India is the most populated country in the world"
                ),
                arrayListOf(false, true, true, false, true, true, true, false, false, true) // Added answers here
            ),

            /*5th SET of questions*/
            QuestionSet(
                QuestionSetIdentifier.SET_FIVE,
                arrayListOf(
                    "Alliumphobia is a fear of garlic",
                    "M&M stands for Mars and Moordale",
                    "A cara cara navel is a type of orange",
                    "Coffee is made from berries",
                    "Spaghetto is the singular word for a piece of spaghetti",
                    "Bananas are curved because they grow upwards towards the sun",
                    "Ketchup was once used to cure diseases like diarrhoea and colds",
                    "Honey will usually never go bad",
                    "The Caesar salad was invented in France",
                    "Pizza was invented in Rome, Italy"
                ),
                arrayListOf(true, false, true, true, true, true, true, true, false, false)
            )
        )
    }
        private var currentQuestionIndex = 0
        private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        selectedQuestionSet = questionSets.random()

        questionTxt = findViewById(R.id.question_Txt)
        statementTxt = findViewById(R.id.statement_Txt)
        trueBtn = findViewById(R.id.trueBtn)
        nextBtn = findViewById(R.id.nextBtn)
        falseBtn = findViewById(R.id.falseBtn)

        displayQuestion()

        trueBtn.setOnClickListener { checkAnswer(true) }
        falseBtn.setOnClickListener { checkAnswer(false) }

        nextBtn.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < selectedQuestionSet.questions.size) {
                displayQuestion()
                statementTxt.text = ""
                trueBtn.isEnabled = true
                falseBtn.isEnabled = true
            } else {
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()

            }
        }
        nextBtn.isEnabled = false

    }
    private fun displayQuestion() {
        questionTxt.text = selectedQuestionSet.questions[currentQuestionIndex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = selectedQuestionSet.answers[currentQuestionIndex]

        if (userAnswer == correctAnswer) {
            statementTxt.text = "Correct!"
            statementTxt.setTextColor(Color.GREEN)
            score++
        } else {
            statementTxt.text = "Incorrect!"
            statementTxt.setTextColor(Color.RED)
        }
        trueBtn.isEnabled = false
        falseBtn.isEnabled = false
        nextBtn.isEnabled = true
    }
}













