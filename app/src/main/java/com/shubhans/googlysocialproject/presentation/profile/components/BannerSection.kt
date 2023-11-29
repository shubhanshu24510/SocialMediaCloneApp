package com.shubhans.googlysocialproject.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shubhans.googlysocialproject.R
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceMedium
import com.shubhans.googlysocialproject.presentation.ui.Theme.Spacesmall
import com.shubhans.googlysocialproject.presentation.utils.toPx

@Composable
fun BannerSection(
    modifier: Modifier = Modifier,
    leftIconModifier: Modifier = Modifier,
    rightIconModifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    iconSize: Dp = 35.dp,
    gitHubClick: () -> Unit = {},
    instragramClick: () -> Unit = {},
    linkedInClick: () -> Unit = {}
) {
    BoxWithConstraints(modifier = modifier) {
        Image(
            modifier = imageModifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.cover_photo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = constraints.maxHeight - iconSize.toPx() * 2f
                    )
                )
        )
        Row(
            modifier = leftIconModifier
                .height(iconSize)
                .align(Alignment.BottomStart)
                .padding(Spacesmall)
        ) {
            Spacer(modifier = Modifier.width(Spacesmall))
            Image(
                painter = painterResource(id = R.drawable.python_5),
                contentDescription = "Javscript",
                modifier = Modifier.height(iconSize)
            )
            Spacer(modifier = Modifier.width(SpaceMedium))
            Image(
                painter = painterResource(id = R.drawable.java),
                contentDescription = "C#",
                modifier = Modifier.height(iconSize)
            )
            Spacer(modifier = Modifier.width(SpaceMedium))
            Image(
                painter = painterResource(id = R.drawable.kotlin_1),
                contentDescription = "Kotlin",
                modifier = Modifier.height(iconSize)
            )
        }
        Row(
            modifier = rightIconModifier
                .height(iconSize)
                .align(Alignment.BottomEnd)
                .padding(Spacesmall)
        ) {
            IconButton(
                onClick = gitHubClick,
                modifier = Modifier.size(iconSize)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.github_icon),
                    contentDescription = "GitHub",
                    modifier = Modifier.size(iconSize)
                )
            }
            IconButton(
                onClick = instragramClick,
                modifier = Modifier.size(iconSize)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.instagram_2016_5),
                    contentDescription = "Instagram",
                    modifier = Modifier.size(iconSize)
                )
            }
            IconButton(
                onClick = linkedInClick,
                modifier = Modifier.size(iconSize)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.linkedin_icon),
                    contentDescription = "LinkedIn",
                    modifier = Modifier.size(iconSize)
                )
            }
        }
    }
}