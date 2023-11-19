package com.shubhans.googlysocialproject.presentation.activity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.shubhans.googlysocialproject.presentation.components.StandardScaffold

@Composable
fun ActivityScreen(navController: NavController) {
    StandardScaffold(
        navController = navController,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Notification Screen")

        }

    }
}