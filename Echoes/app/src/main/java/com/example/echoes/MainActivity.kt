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
        val btnNavigate2 : Button = findViewById(R.id.button3)
        btnNavigate.setOnClickListener {
            val intentNavigate = Intent(this, LoginActivity().javaClass)

            startActivity(intentNavigate)
        }
        btnNavigate2.setOnClickListener {
            val intentNavigate = Intent(this, AboutActivity().javaClass)

            startActivity(intentNavigate)
        }
    }
}