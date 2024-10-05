package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlistapp.data.Graph

import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishVIewModel(private val repository: WishRepository = Graph.wishRepository
) :ViewModel() {
    var descriptionState by mutableStateOf("")
    var titleState by mutableStateOf("")


    fun onTitleChanged(newString: String) {
        titleState = newString
    }

    fun onDescriptionChanged(newString: String) {
        descriptionState = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = repository.getAllWishes()
        }
    }

    fun addaWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAWish(wish = wish)
        }
    }

    fun updateaWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateWish(wish = wish)
        }
    }

    fun deleteAWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAWish(wish = wish)
        }
    }

    fun getAWish(id: Long): Flow<Wish> {
        return repository.getAWish(id)
    }


}