package com.example.cristobalbuenoexam.Activities

import android.os.Bundle
import android.os.Handler
import com.example.cristobalbuenoexam.AbstractClass.BaseActivity
import com.example.cristobalbuenoexam.R

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {

            gotoActivity(MainActivity())
            finish()

        }, 1500)
    }
}
