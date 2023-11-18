package com.shubhans.googlysocialproject.presentation.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shubhans.googlysocialproject.presentation.main_feed.MainFeedScreen
import com.shubhans.googlysocialproject.presentation.login.LoginScreen
import com.shubhans.googlysocialproject.presentation.register.RegisterScreen
import com.shubhans.googlysocialproject.presentation.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(navController=navController )
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController =navController)
        }
        composable(Screen.MainFeedScreen.route){
           MainFeedScreen(navController =navController)
        }
//        composable(Screen.ChatScreen.route){
//            ChatScreen(navController =navController)
//        }
//        composable(Screen.ActivityScreen.route) {
//            ActivityScreen(navController = navController)
//        }
//        composable(Screen.ProfileScreen.route){
//            ProfileScreen(navController = navController)
//        }
    }
}