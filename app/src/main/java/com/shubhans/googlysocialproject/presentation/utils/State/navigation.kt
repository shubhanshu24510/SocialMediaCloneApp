package com.shubhans.googlysocialproject.presentation.utils.State

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shubhans.googlysocialproject.domain.m.model.Post
import com.shubhans.googlysocialproject.presentation.activity.ActivityScreen
import com.shubhans.googlysocialproject.presentation.chat.ChatScreen
import com.shubhans.googlysocialproject.presentation.create_post.CreatePostScreen
import com.shubhans.googlysocialproject.presentation.login.LoginScreen
import com.shubhans.googlysocialproject.presentation.main_feed.MainFeedScreen
import com.shubhans.googlysocialproject.presentation.post_details.PostDetailsScreen
import com.shubhans.googlysocialproject.presentation.profile.ProfileScreen
import com.shubhans.googlysocialproject.presentation.register.RegisterScreen
import com.shubhans.googlysocialproject.presentation.splash.SplashScreen
import com.shubhans.googlysocialproject.presentation.utils.Screen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = Screen.SplashScreen.route,
        modifier = Modifier.fillMaxSize()){
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
        composable(Screen.ChatScreen.route){
            ChatScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.CreatePostScreen.route){
            CreatePostScreen(navController =navController)
        }
        composable(Screen.PostDetailsScreen.route){
            PostDetailsScreen(navController =navController,
                post = Post(
                    username = "shubhans24510",
                    imageUrl = "",
                    profilePictureUrl = "",
                    description = "Absolutely adore Quito! Nestled amid stunning mountains, this city captivates with its rich history",
                    likeCount = 54,
                    commentCount = 14
                )
            )
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
    }
}