package com.example.dummysix.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity
import com.example.dummysix.R
import com.example.dummysix.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val LAUNCH_DELAY: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Image by mode in system
//        when (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
//            Configuration.UI_MODE_NIGHT_NO -> iv.setImageResource(R.drawable.ic_launcher_background)
//            Configuration.UI_MODE_NIGHT_YES -> iv.setImageResource(R.drawable.ic_launcher_background)
//            Configuration.UI_MODE_NIGHT_UNDEFINED -> iv.setImageResource(R.drawable.ic_launcher_background)
//        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            Handler(Looper.getMainLooper()).postDelayed({
                intent = Intent(applicationContext, MainActivity::class.java)
                launch(intent)
            }, LAUNCH_DELAY)
        } else {
            launch(Intent(applicationContext, MainActivity::class.java))
        }

    }

    private fun launch(intent: Intent) {
        startActivity(intent)
        finish()
    }
}