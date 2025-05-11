package com.tops.android

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tops.android.databinding.LoginActivityBinding

class LoginActivity :AppCompatActivity() {

    private lateinit var binding : LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = getString(R.string.login)

        binding.bsubmit.setOnClickListener{

            val username  = binding.tusername.text.toString().trim()
            val password = binding.tpassword.text.toString().trim()

            if (username=="Jay" && password=="Jay1234"){
                val intent =Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }else{
                // code
            }
        }

        binding.tsignup.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }
}