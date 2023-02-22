package com.example.echoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnNavigate : Button = findViewById(R.id.button)
        btnNavigate.setOnClickListener {
            val intentNavigate = Intent(this, LoginActivity().javaClass)

            startActivity(intentNavigate)   // Send Data and Navigate
        }
    }
}