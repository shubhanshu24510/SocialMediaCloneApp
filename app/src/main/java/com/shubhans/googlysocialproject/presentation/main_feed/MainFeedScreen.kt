package com.shubhans.googlysocialproject.presentation.main_feed

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.shubhans.googlysocialproject.presentation.components.Post
import com.shubhans.googlysocialproject.presentation.components.StandardScaffold

@Composable
fun MainFeedScreen(navController: NavController) {
    StandardScaffold(navController = navController, content = { /*TODO*/ })

    Post(
        post = com.shubhans.googlysocialproject.domain.model.Post(
            username = "shubhanshu2451",
            imageUrl = "",
            profilePictureUrl = "",
            description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\n" +
                    "diam nonumy eirmod tempor invidunt ut labore et dolore \n" +
                    "magna aliquyam erat, sed diam voluptua...",
            likeCount = 53,
            commentCount = 13
        )
    )
}



