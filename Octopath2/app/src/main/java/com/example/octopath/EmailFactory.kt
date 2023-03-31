package com.example.octopath

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EmailFactory(private val email:String):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EmailList::class.java)){
            return EmailList(email) as T
        }
        throw java.lang.IllegalArgumentException("Do not recognize View model class")
    }
}