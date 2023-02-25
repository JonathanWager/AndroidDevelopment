package com.example.echoes

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val userName : EditText = findViewById(R.id.username)
        val userPassword : EditText = findViewById(R.id.password)
        val btnNavigate : Button = findViewById(R.id.button2)
        val textNavigate : TextView = findViewById(R.id.textView)
        val user = ArrayList<String>()
        user.add("Jonathan")
        user.add("Kanelbulle23")
        user.add(intent.getStringExtra("key_username").toString())
        user.add(intent.getStringExtra("key_password").toString())

        textNavigate.setOnClickListener{
            val intentNavigate = Intent(this, SignInActivity().javaClass)

            startActivity(intentNavigate)
        }

        btnNavigate.setOnClickListener {
            if (userName.text.toString() in user && userPassword.text.toString() == user[1+user.indexOf(userName.text.toString())]){
                val intentNavigate = Intent(this, LoggedInActivity().javaClass).apply {
                    putExtra("user_name", userName.text.toString())
                }

                startActivity(intentNavigate)
            }
            else{
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