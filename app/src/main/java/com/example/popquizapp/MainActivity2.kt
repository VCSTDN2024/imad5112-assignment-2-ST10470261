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

    companion object {
        val questions = arrayOf(
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
            if (currentQuestionIndex < questions.size) {
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
        /*val intent = Intent(this, MainActivity4::class.java)
        intent.putExtra("questions", questions)
        intent.putExtra("answers", answers)
        startActivity(intent)*/


    }
    private fun displayQuestion() {
        questionTxt.text = questions[currentQuestionIndex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]

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













