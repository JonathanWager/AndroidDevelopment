package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewCounter: TextView = findViewById(R.id.textView)
        val myButton: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.hideAndSeek)
        val myButton2: Switch = findViewById(R.id.switch1)

        val viewModel: CounterViewModel by viewModels()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect(){
                    textViewCounter.text = viewModel.uiState.value.counterValue.toString()
                }
            }
        }

        myButton.setOnClickListener {
            viewModel.add()
        }
        myButton2.setOnClickListener{
            if (textView.visibility == View.VISIBLE) {
                textView.visibility = View.INVISIBLE
            } else {
                textView.visibility = View.VISIBLE
            }
        }
    }
}