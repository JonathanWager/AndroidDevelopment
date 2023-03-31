package com.example.octopath

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EmailList(email: String): ViewModel() {
    private var emails = ArrayList<String>()
    private var mail = email

    fun addEmail(){
        emails.add(mail)
    }

    fun delete(){
        emails.clear()
    }
}
