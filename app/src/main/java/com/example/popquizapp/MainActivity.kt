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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val welcomingMessage = findViewById<TextView>(R.id.welcoming_Msg)
        val appInstructions = findViewById<TextView>(R.id.app_Instr)
        val startButton = findViewById<Button>(R.id.startBtn)
        val exitButton = findViewById<Button>(R.id.exitBtn)

        welcomingMessage.text = "POP! Quiz!!!!!"
        appInstructions.text = "  When ready to begin, click the start button below."

        startButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }
}