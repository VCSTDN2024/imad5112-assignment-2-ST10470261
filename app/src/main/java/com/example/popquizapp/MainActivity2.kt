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

    private lateinit var question_Txt: TextView
    private lateinit var statement_Txt: TextView
    private lateinit var trueBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var falseBtn: Button

    companion object {
        val questions = arrayOf(
            "1.The star sign Aquarius is represented by a tiger",
            "2.'A' is the most common letter used in the English language ",
            "3.ASOS stands for As Seen On Screen",
            "4.The Battle Of Hastings took place in 1066",
            "5.H&M stands for Hennes & Mauritz",
            "6.K is worth four points in Scrabble",
            "7.In a deck of cards, the king has a moustache",
            "8.When the two numbers on opposite sides of a dice are added together it always equals 7",
            "9.In the English language there is no word that rhymes with orange",
            "10.English is the most spoken language in the world"
        )
        val answers =
            booleanArrayOf(false, false, true, true, true, true, false, true, true, false)
    }
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        question_Txt = findViewById(R.id.question_Txt)
        statement_Txt = findViewById(R.id.statement_Txt)
        trueBtn = findViewById(R.id.trueBtn)
        nextBtn = findViewById(R.id.nextBtn)
        falseBtn = findViewById(R.id.falseBtn)

        displayQuestion()

        trueBtn.setOnClickListener { checkAnswer(true) }
        falseBtn.setOnClickListener { checkAnswer(false) }

        nextBtn.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
                statement_Txt.text = ""
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
        question_Txt.text = questions[currentQuestionIndex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]

        if (userAnswer == correctAnswer) {
            statement_Txt.text = "Correct!"
            statement_Txt.setTextColor(Color.GREEN)
            score++
        } else {
            statement_Txt.text = "Incorrect!"
            statement_Txt.setTextColor(Color.RED)
        }
        trueBtn.isEnabled = false
        falseBtn.isEnabled = false
        nextBtn.isEnabled = true
    }
}












