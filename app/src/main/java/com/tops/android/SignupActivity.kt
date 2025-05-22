package com.tops.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.tops.android.databinding.SignupActivityBinding

class SignupActivity: AppCompatActivity() {
    private lateinit var binding: SignupActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = SignupActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "SignUp"

        binding.btnSignup.setOnClickListener(){
            var rname = binding.tname.text.toString().trim()
            var remail = binding.temail.text.toString().trim()
            var rusername = binding.trusername.text.toString().trim()
            var rpassword = binding.trpassword.text.toString().trim()

            val intent =Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRlogin.setOnClickListener(){
            var intent =Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}