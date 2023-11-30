package com.shubhans.googlysocialproject.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shubhans.googlysocialproject.R
import com.shubhans.googlysocialproject.presentation.ui.Theme.ProfilePictureSizeMedium
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceMedium
import com.shubhans.googlysocialproject.presentation.ui.Theme.Spacesmall
import com.shubhans.googlysocialproject.presentation.ui.Theme.iconSizeMedium

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserProfileItem(
    modifier: Modifier = Modifier,
    user: com.shubhans.googlysocialproject.domain.m.model.User,
    onItemClick: () -> Unit = {},
    onActionItemClick: () -> Unit = {},
    actionIcon: @Composable () -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        onClick = onItemClick,
        elevation = 5.dp
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = Spacesmall, horizontal = SpaceMedium),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = null,
                modifier = Modifier
                    .size(ProfilePictureSizeMedium)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.8f)
                    .padding(horizontal = Spacesmall)
            ) {
                Text(
                    text = user.username,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = user.description,
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }
            IconButton(
                onClick = onActionItemClick,
                modifier = Modifier.size(iconSizeMedium)
            ) {
                actionIcon()
            }
        }
    }
}