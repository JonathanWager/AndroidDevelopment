package com.example.octopath

import android.app.Activity
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var emailViewModel: EmailList
    val myButton: Button = findViewById(R.id.button)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.fragmentContainerView2)
        val textNavigate : TextView = findViewById(R.id.textView)
        val textNavigate2 : TextView = findViewById(R.id.textView2)

        textNavigate.setOnClickListener {
            navController.navigateUp()
            navController.navigate(R.id.functionFragment)
        }

        textNavigate2.setOnClickListener {
            navController.navigateUp()
            navController.navigate(R.id.aboutFragment)
        }
    }
    var musicPlayer: MediaPlayer? = null
    var choice: Int = 0
    fun playMusic3(view: View) {
        if (musicPlayer!=null && choice != 3){
            choice = 3
            musicPlayer!!.stop()
            musicPlayer!!.release()
            musicPlayer = null
            musicPlayer = MediaPlayer.create(this, R.raw.mq13)
            musicPlayer!!.start()
        }
        if (choice == 3){
            musicPlayer!!.start()
        }
        else{
            choice = 3
            musicPlayer = MediaPlayer.create(this, R.raw.mq13)
            musicPlayer!!.start()
        }
    }
    fun playMusic2(view: View) {
        if (musicPlayer!=null && choice != 2){
            choice = 2
            musicPlayer!!.stop()
            musicPlayer!!.release()
            musicPlayer = null
            musicPlayer = MediaPlayer.create(this, R.raw.daughterofthedarkgod)
            musicPlayer!!.start()
        }
        if (choice == 2){
            musicPlayer!!.start()
        }
        else{
            choice = 2
            musicPlayer = MediaPlayer.create(this, R.raw.daughterofthedarkgod)
            musicPlayer!!.start()
        }
    }
    fun playMusic(view: View) {
        if (musicPlayer!=null && choice != 1){
            choice = 1
            musicPlayer!!.stop()
            musicPlayer!!.release()
            musicPlayer = null
            musicPlayer = MediaPlayer.create(this, R.raw.forsuccordecisivebattle2)
            musicPlayer!!.isLooping = true
            musicPlayer!!.start()
        }
        if (choice == 1){
            musicPlayer!!.start()
        }
        else{
            choice = 1
            musicPlayer = MediaPlayer.create(this, R.raw.forsuccordecisivebattle2)
            musicPlayer!!.start()
        }
    }

    fun pauseMusic(view: View){
        if (musicPlayer?.isPlaying == true) musicPlayer?.pause()
    }

    override fun onStop() {
        super.onStop()
        if(musicPlayer!= null){
            musicPlayer!!.release()
            musicPlayer = null
        }
    }

    fun next(view: View) {
        val mm : FloatingActionButton = findViewById(R.id.floatingActionButton)
        val navController = findNavController(R.id.fragmentContainerView2)
        navController.navigateUp()
        navController.navigate(R.id.newsletterFragment)
    }

    fun addEmail(view: View){
        val userName : EditText = findViewById(R.id.editTextTextEmailAddress)
        myButton.setOnClickListener {
            emailViewModel.emails.add(userName.toString())
            Snackbar.make(findViewById(R.id.LetterLayout),"You will recieve letter", Snackbar.LENGTH_LONG)
                .setAction("Undo",{ _ -> emailViewModel.emails.clear()}).show()
        }
    }
}