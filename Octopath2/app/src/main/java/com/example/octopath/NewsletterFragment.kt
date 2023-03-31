package com.example.octopath

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

class NewsletterFragment : Fragment() {

    private lateinit var emailViewModel: EmailList
    private lateinit var viewModelFactory:EmailFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_newsletter, container, false)

        val myButton: Button = view.findViewById(R.id.button)
        val userName : EditText = view.findViewById(R.id.editTextTextEmailAddress)
        viewModelFactory = EmailFactory(userName.toString())
        emailViewModel = ViewModelProvider(this,viewModelFactory)[EmailList::class.java]
        myButton.setOnClickListener {
            viewModelFactory = EmailFactory(userName.toString())
            emailViewModel.addEmail()
            Snackbar.make(view.findViewById(R.id.LetterLayout),"You will recieve letter", Snackbar.LENGTH_LONG)
                .setAction("Undo") { emailViewModel.delete() }.show()
        }
        return view
    }
}