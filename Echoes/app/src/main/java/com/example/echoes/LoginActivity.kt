package com.example.echoes

import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val userName : EditText = findViewById(R.id.username)
        val userPassword : EditText = findViewById(R.id.password)
        val btnNavigate : Button = findViewById(R.id.button2)
        val textNavigate : TextView = findViewById(R.id.textView)
        val number : Int = 2

        textNavigate.setOnClickListener{
            val intentNavigate = Intent(this, SignInActivity().javaClass)

            startActivity(intentNavigate)
        }

        btnNavigate.setOnClickListener {
            if (number==2){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Alert")
                builder.setMessage("Invalid username or password")

                builder.setPositiveButton(android.R.string.ok) { _, _ ->
                    Toast.makeText(applicationContext,
                        android.R.string.ok, Toast.LENGTH_SHORT).show()
                }
                builder.show()
            }
        }
    }
}