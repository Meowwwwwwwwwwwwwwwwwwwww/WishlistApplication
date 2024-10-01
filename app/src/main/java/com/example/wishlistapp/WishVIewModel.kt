package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WishVIewModel:ViewModel() {
    var descriptionState by mutableStateOf("")
    var titleState by mutableStateOf("")

    fun onTitleChanged(newString: String){
           titleState=newString
    }
    fun onDescriptionChanged(newString: String){
            descriptionState=newString
    }

}