package com.example.movieapp.navigation

import android.graphics.Movie
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.screens.home.details.DetailsScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){
            //here we pass where this should lead us to
            HomeScreen(navController = navController)
        }
        composable(MovieScreens.DetailsScreen.name){
            DetailsScreen(navController = navController)
        }
    }
}