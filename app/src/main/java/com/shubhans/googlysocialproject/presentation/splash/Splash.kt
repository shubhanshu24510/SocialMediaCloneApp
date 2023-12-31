package com.shubhans.googlysocialproject.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.shubhans.googlysocialproject.R
import com.shubhans.googlysocialproject.presentation.utils.Constants
import com.shubhans.googlysocialproject.presentation.utils.Screen
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun SplashScreen(navController: NavController,
                 dispatcher: CoroutineDispatcher =Dispatchers.Main) {
    val scale = remember { Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true) {
        withContext(dispatcher){
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(
                    durationMillis = 5000,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
            delay(Constants.Splash_screen_duration)
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)
        }

    }

    Box(modifier = Modifier.fillMaxSize(),
contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id =R.drawable.ezgif_com_gif_maker),
            contentDescription = "splash icon",
            modifier = Modifier.scale(scale.value))

    }

}