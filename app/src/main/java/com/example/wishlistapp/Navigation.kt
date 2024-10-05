package com.example.wishlistapp

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun Navigation(viewModel: WishVIewModel = viewModel(), nav: NavHostController = rememberNavController()) {
    NavHost(navController =nav , startDestination = Screen.HomeScreen.route ){
        composable(route = Screen.HomeScreen.route){
            HomeView(viewModel,nav)
        }
        composable(route=Screen.AddScreen.route +"/{id}",
                   arguments= listOf(
                       navArgument("id"){
                       type= NavType.LongType
                       defaultValue=0L
                       nullable=false
                   })
            ){entry->
            val id= if(entry.arguments!=null) entry.arguments!!.getLong("id") else 0L
            AddEditDetails(viewModel = viewModel, id =id , navController =nav )

        }

    }
}