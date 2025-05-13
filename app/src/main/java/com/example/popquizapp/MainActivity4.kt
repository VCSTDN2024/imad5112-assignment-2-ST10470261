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


      /*  val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")*/



        val reviewText = StringBuilder()
        val currentSet1 = MainActivity2.questionSets.find { it.id == MainActivity2.QuestionSetIdentifier.SET_ONE }
        val currentSet2 = MainActivity2.questionSets.find { it.id == MainActivity2.QuestionSetIdentifier.SET_TWO }
        val currentSet3 = MainActivity2.questionSets.find { it.id == MainActivity2.QuestionSetIdentifier.SET_THREE }
        val currentSet4 = MainActivity2.questionSets.find { it.id == MainActivity2.QuestionSetIdentifier.SET_FOUR }
        val currentSet5 = MainActivity2.questionSets.find { it.id == MainActivity2.QuestionSetIdentifier.SET_FIVE }



        if (currentSet1 != null) {
            val questionsForSet = currentSet1.questions
            val answersForSet = currentSet1.answers

            if (questionsForSet != null && answersForSet != null && questionsForSet.size == answersForSet.size) {
                for (i in questionsForSet.indices) {
                    reviewText.append("${i + 1}. ${questionsForSet[i]}\n")
                    reviewText.append(" Answer: ${if (answersForSet[i]) "True" else "False"}\n\n")
                }
                reviewTextView.text = reviewText.toString()
            } else {
                reviewTextView.text = "Error: Inconsistent question/answer data for ${MainActivity2.QuestionSetIdentifier.SET_ONE}"
            }
        }
        if (currentSet2 != null) {
            val questionsForSet = currentSet2.questions
            val answersForSet = currentSet2.answers

            if (questionsForSet != null && answersForSet != null && questionsForSet.size == answersForSet.size) {
                for (i in questionsForSet.indices) {
                    reviewText.append("${i + 1}. ${questionsForSet[i]}\n")
                    reviewText.append(" Answer: ${if (answersForSet[i]) "True" else "False"}\n\n")
                }
                reviewTextView.text = reviewText.toString()
            } else {
                reviewTextView.text = "Error: Inconsistent question/answer data for ${MainActivity2.QuestionSetIdentifier.SET_TWO}"
            }
        }
        if (currentSet3 != null) {
            val questionsForSet = currentSet3.questions
            val answersForSet = currentSet3.answers

            if (questionsForSet != null && answersForSet != null && questionsForSet.size == answersForSet.size) {
                for (i in questionsForSet.indices) {
                    reviewText.append("${i + 1}. ${questionsForSet[i]}\n")
                    reviewText.append(" Answer: ${if (answersForSet[i]) "True" else "False"}\n\n")
                }
                reviewTextView.text = reviewText.toString()
            }
        } else {
            reviewTextView.text = "Error: Question set ${MainActivity2.QuestionSetIdentifier.SET_THREE} not found"
        }
        if (currentSet4 != null) {
            val questionsForSet = currentSet4.questions
            val answersForSet = currentSet4.answers

            if (questionsForSet != null && answersForSet != null && questionsForSet.size == answersForSet.size) {
                for (i in questionsForSet.indices) {
                    reviewText.append("${i + 1}. ${questionsForSet[i]}\n")
                    reviewText.append(" Answer: ${if (answersForSet[i]) "True" else "False"}\n\n")
                }
                reviewTextView.text = reviewText.toString()
            } else {
                reviewTextView.text = "Error: Inconsistent question/answer data for ${MainActivity2.QuestionSetIdentifier.SET_FOUR}"
            }
        }
        if (currentSet5 != null) {
            val questionsForSet = currentSet5.questions
            val answersForSet = currentSet5.answers

            if (questionsForSet != null && answersForSet != null && questionsForSet.size == answersForSet.size) {
                for (i in questionsForSet.indices) {
                    reviewText.append("${i + 1}. ${questionsForSet[i]}\n")
                    reviewText.append(" Answer: ${if (answersForSet[i]) "True" else "False"}\n\n")
                }
                reviewTextView.text = reviewText.toString()
            } else {
                reviewTextView.text = "Error: Inconsistent question/answer data for ${MainActivity2.QuestionSetIdentifier.SET_FIVE}"
            }
        }


        restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}



