package com.example.echoes

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val userName : EditText = findViewById(R.id.username)
        val userPassword : EditText = findViewById(R.id.password)
        val btnNavigate : Button = findViewById(R.id.button2)
        val textNavigate : TextView = findViewById(R.id.textView)
        val user = ArrayList<String>()
        user.add("Jonathan")
        user.add("Kanelbulle23")

        textNavigate.setOnClickListener {
            val intentNavigate = Intent(this, LoginActivity().javaClass)

            startActivity(intentNavigate)
        }
        btnNavigate.setOnClickListener {
            if (userName.text.toString() in user){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Alert")
                builder.setMessage("You have already made an account with this username")

                builder.setPositiveButton(android.R.string.ok) { _, _ ->
                    Toast.makeText(applicationContext,
                        android.R.string.ok, Toast.LENGTH_SHORT).show()
                }
                builder.show()
            }
            else{
                val intentNavigate = Intent(this, LoginActivity().javaClass).apply {
                    putExtra("key_username", userName.text.toString())
                    putExtra("key_password", userPassword.text.toString())
                }
                user.add(userName.text.toString())
                startActivity(intentNavigate)
            }
        }
    }
}