package com.example.myselfapps_10122909_fiqrisepdian

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.myselfapps_10122909_fiqrisepdian.walkthrough.WalkthroughActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, WalkthroughActivity::class.java))
            finish()
        }, 2000)
    }
}
