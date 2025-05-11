package com.tops.android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.tops.android.databinding.DashboardActivityBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: DashboardActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DashboardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Dashboard"

        // Example: Show a welcome message
        binding.textWelcome.text = "Welcome, Jay!"
    }
}
