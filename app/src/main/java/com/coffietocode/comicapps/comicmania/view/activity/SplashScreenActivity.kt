package com.coffietocode.comicapps.comicmania.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.coffietocode.comicapps.comicmania.R


class SplashScreenActivity : AppCompatActivity() {

    private val mSPlashScreenDelay: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        Handler().postDelayed({ gotoNextActivity() }, mSPlashScreenDelay)
    }

    private fun gotoNextActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        this.finish()
    }

}
