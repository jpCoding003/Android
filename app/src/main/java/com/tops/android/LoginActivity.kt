package com.tops.android

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tops.android.databinding.LoginActivityBinding

private const val Tag = "LoginFragment"
val IS_Login = "IS_Login"
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
                val intent =Intent(this, DashboardDrawerActivity::class.java)
                startActivity(intent)
            }else{
                // code
                Toast.makeText(this, "Enter valid detail", Toast.LENGTH_SHORT).show()
            }

            val sharedPref = getSharedPreferences(
                getString(R.string.app_name), MODE_PRIVATE
            )?: return@setOnClickListener
            with (sharedPref.edit()) {
                putBoolean(IS_Login, true)
                apply()
                Log.i( TAG , " Shared")
            }

        }

        binding.tsignup.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}