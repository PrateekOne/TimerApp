// src/main/java/com/example/timerapp/MainActivity.kt

package com.example.timerapp

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var timerText: TextView
    private lateinit var waterMotorButton: Button
    private lateinit var breadToastButton: Button
    private lateinit var milkButton: Button
    private lateinit var waterBoilingButton: Button

    private var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerText = findViewById(R.id.timerText)
        waterMotorButton = findViewById(R.id.waterMotorButton)
        breadToastButton = findViewById(R.id.breadToastButton)
        milkButton = findViewById(R.id.milkButton)
        waterBoilingButton = findViewById(R.id.waterBoilingButton)

        waterMotorButton.setOnClickListener { startTimer(10 * 60 * 1000, "Water Motor is Ready") } // 10 minutes
        breadToastButton.setOnClickListener { startTimer(5 * 60 * 1000, "Bread Toast is Ready") } // 5 minutes
        milkButton.setOnClickListener { startTimer(2 * 60 * 1000, "Milk is Ready") } // 2 minutes
        waterBoilingButton.setOnClickListener { startTimer(1 * 60 * 1000, "Water is Boiling") } // 1 minute
    }

    private fun startTimer(duration: Long, message: String) {
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 1000 / 60
                val seconds = (millisUntilFinished / 1000) % 60
                timerText.text = String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                timerText.text = "00:00"
                Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
            }
        }.start()
    }
}

