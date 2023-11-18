package com.shubhans.googlysocialproject.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Doorbell
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shubhans.googlysocialproject.domain.model.BottomNavItem
import com.shubhans.googlysocialproject.presentation.StandardBottomNavItem
import com.shubhans.googlysocialproject.presentation.utils.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    viewModel: StandardSccafoldViewModel = hiltViewModel(),
    bottomNavItem: List<BottomNavItem> = listOf(
        BottomNavItem(route = Screen.MainFeedScreen.route,
            icon = Icons.Outlined.Home,
            contentDescription = "Home"),
        BottomNavItem(route = Screen.ChatScreen.route,
            icon = Icons.Outlined.Message,
            contentDescription = "Message"),
        BottomNavItem(route = Screen.ActivityScreen.route,
            icon = Icons.Outlined.Doorbell,
            contentDescription = "Notification"),
        BottomNavItem(route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person,
            contentDescription = "Profile")
    )
) {
    Scaffold(bottomBar = {
        BottomAppBar(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.surface,
            cutoutShape = CircleShape,
            elevation = 5.dp
        ) {
            BottomNavigation {
                bottomNavItem.forEachIndexed() { i, bottomNavItem ->
                    StandardBottomNavItem(
                        icon = bottomNavItem.icon,
                        contentDescription =bottomNavItem.contentDescription,
                        selected = viewModel.selectedBottomNavItem.value == i,
                        alertCount = bottomNavItem.alertCount
                    ) {
                        navController.navigate(bottomNavItem.route)
                    }
                }
            }
        }

    }) {
        content()

    }
}