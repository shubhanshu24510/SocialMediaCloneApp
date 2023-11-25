package com.shubhans.googlysocialproject.presentation.activity.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubhans.googlysocialproject.R
import com.shubhans.googlysocialproject.domain.m.model.Activity
import com.shubhans.googlysocialproject.domain.util.ActivityAction
import com.shubhans.googlysocialproject.presentation.ui.Theme.Spacesmall

@Composable
fun ActivityItem(
    modifier: Modifier = Modifier,
    activity: Activity
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(Spacesmall),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            val fillerText = when (activity.actionType) {
                is ActivityAction.likedPost ->
                    stringResource(id = R.string.li_ke)

                is ActivityAction.commentonPost ->
                    stringResource(id = R.string.commented_on)

                is ActivityAction.followedYou ->
                    stringResource(id = R.string.followed_you)

            }
            val actionText = when (activity.actionType) {
                is ActivityAction.likedPost ->
                    stringResource(id = R.string.your_post)

                is ActivityAction.commentonPost ->
                    stringResource(id = R.string.your_post)

                is ActivityAction.followedYou -> ""

            }
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)
                    withStyle(boldStyle) {
                        append(activity.username)
                    }
                    append(" $fillerText")
                    withStyle(boldStyle) {
                        append(actionText)
                    }
                },
                fontSize = 12.sp,
                color = MaterialTheme.colors.onBackground

            )
            Text(
                text = activity.formattedTime,
                textAlign = TextAlign.Right,
                fontSize = 12.sp,
                color = MaterialTheme.colors.onBackground
            )

        }

    }


}