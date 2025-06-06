package com.tops.android

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

@Suppress("DEPRECATION")
class SplashActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        enableEdgeToEdge()
        supportActionBar?.hide()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPref = getSharedPreferences(getString(R.string.app_name),Context.MODE_PRIVATE)
        val isLogin= sharedPref.getBoolean(IS_Login,false)

        Handler().postDelayed({

            if (isLogin == true){
                val intent = Intent(this , DashboardDrawerActivity::class.java)
                startActivity(intent)
            }else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        },3000)
    }
}