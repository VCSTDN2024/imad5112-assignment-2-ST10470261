package com.example.popquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val scoreText = findViewById<TextView>(R.id.scoreTxt)
        val feedbackTxt = findViewById<TextView>(R.id.feedback_Txt)
        val reviewButton = findViewById<Button>(R.id.reviewBtn)
        val exitButton = findViewById<Button>(R.id.exitBtn)

        val score = intent.getIntExtra("score", 0)
        scoreText.text = "$score/10"

        val feedback = if (score >= 5) {    "Great job!"} else {    "Keep practicing!"}
        feedbackTxt.text = feedback

        reviewButton.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            intent.putExtra("questions", MainActivity2.questions)
            intent.putExtra("answers", MainActivity2.answers)
            startActivity(intent)
        }
        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}