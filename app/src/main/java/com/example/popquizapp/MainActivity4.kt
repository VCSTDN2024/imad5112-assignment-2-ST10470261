package com.example.popquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val reviewTextView = findViewById<TextView>(R.id.reviewTxt)
        val restartButton = findViewById<Button>(R.id.restartBtn)
        val exitButton = findViewById<Button>(R.id.exitBtn)

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                reviewText.append("${i + 1}. ${questions[i]}\n")
                reviewText.append(" Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            reviewTextView.text = reviewText.toString()
        } else {
            reviewTextView.text = "No review available."
        }

        restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}



