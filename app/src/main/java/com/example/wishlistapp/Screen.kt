package com.example.wishlistapp

 sealed class Screen (val route :String){
     object HomeScreen :Screen("homeScreen")
     object AddScreen :Screen("addScreen")

}