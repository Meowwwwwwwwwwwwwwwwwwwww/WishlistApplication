package com.example.wishlistapp

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable

@Composable
fun Navigation(viewModel: WishVIewModel = viewModel(), nav: NavHostController= rememberNavController()) {
    NavHost(navController =nav , startDestination = Screen.HomeScreen.route ){
        composable(route = Screen.HomeScreen.route){
            HomeView(viewModel,nav)
        }
        composable(route=Screen.AddScreen.route){
            AddEditDetails(viewModel = viewModel, id =0L , navController =nav )

        }

    }
}