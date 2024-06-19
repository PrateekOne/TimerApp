// src/main/java/com/example/timerapp/MainActivity.kt
package com.example.timerapp

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun startTimer(message: String, seconds: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        startActivity(intent)
    }

    fun waterMotor(view: View) {
        startTimer("Water Motor", 10 * 60)
    }

    fun breadToast(view: View) {
        startTimer("Bread Toast", 5 * 60)
    }

    fun milk(view: View) {
        startTimer("Milk", 2 * 60)
    }

    fun waterBoiling(view: View) {
        startTimer("Water Boiling", 1 * 60)
    }
}
