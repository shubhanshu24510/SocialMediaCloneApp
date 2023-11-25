package com.shubhans.googlysocialproject.presentation.activity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.shubhans.googlysocialproject.R
import com.shubhans.googlysocialproject.domain.m.model.Activity
import com.shubhans.googlysocialproject.domain.m.util.DateFormat
import com.shubhans.googlysocialproject.domain.util.ActivityAction
import com.shubhans.googlysocialproject.presentation.activity.components.ActivityItem
import com.shubhans.googlysocialproject.presentation.components.StandardScaffold
import com.shubhans.googlysocialproject.presentation.components.StandardTopToolBar
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceMedium
import kotlin.random.Random

@Composable
fun ActivityScreen(navController: NavController) {
    StandardScaffold(
        navController = navController,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            StandardTopToolBar(
                navController = navController,
                title = {
                    Text(
                        text = stringResource(id = R.string.your_activity),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onBackground
                    )
                },
                showBackArrow = true,
                modifier = Modifier.fillMaxWidth()
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(SpaceMedium)
            ) {
                items (19) {
                    ActivityItem(
                        activity =
                        Activity(
                            "shubhans2451",
                            actionType = if (Random.nextInt(2) == 0) {
                                ActivityAction.likedPost
                            } else ActivityAction.commentonPost,
                            formattedTime = DateFormat.timestampToFormattedString(
                                timestamp = System.currentTimeMillis(),
                                pattern = "MMM dd HH:mm"
                            )

                        ),
                    )
                    if (it <19){
                        Spacer(modifier = Modifier.height(SpaceMedium))
                    }
                }
            }
        }
    }
}