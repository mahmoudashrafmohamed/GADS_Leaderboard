package com.mahmoud_ashraf.gadsleaderboard.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mahmoud_ashraf.gadsleaderboard.R
import com.mahmoud_ashraf.gadsleaderboard.presentation.main.MainActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

   private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        activityScope.launch {
            delay(3000)

            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}