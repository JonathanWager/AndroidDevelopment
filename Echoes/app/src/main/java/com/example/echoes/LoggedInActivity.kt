package com.example.echoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoggedInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        val displayUsername: TextView = findViewById(R.id.textView5) // TextView
        displayUsername.text = intent.getStringExtra("user_name")
    }
}