package com.example.karakteranime

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val countdownTimer = object : CountDownTimer(3000L, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                //tidak digunakan karena tidak diperlukan ada countdown
            }
            override fun onFinish() {
                navigateToMainActivity()
            }
        }
        countdownTimer.start()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}