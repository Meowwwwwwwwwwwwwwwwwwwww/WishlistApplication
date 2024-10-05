package com.example.wishlistapp.data

import android.content.Context
import androidx.room.Room

object Graph {  // object is used to declare a singleton ,object graph is an example of simple dependency injection steup in kotlin
                // singleton in kotlin is a class whose object is created only once in a a whole app
                //it is used as a service locator that will provide dependency to whole app

    lateinit var database: WishDatabase
    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    // this code inside this brackets will be executed only once when the Wish repository is accessed

    }
    fun provide(context: Context){
        database= Room.databaseBuilder(context, WishDatabase::class.java,"wishdatabase.db").build()

    // this is used to create a instance of our WishDatabase and to store our data locally into wishdatabase.db file
   // then this instance is stored into database variable
    }
}