package com.shubhans.googlysocialproject.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shubhans.googlysocialproject.R
import com.shubhans.googlysocialproject.domain.m.model.Post
import com.shubhans.googlysocialproject.presentation.ui.Theme.HintGray
import com.shubhans.googlysocialproject.presentation.ui.Theme.MediumGray
import com.shubhans.googlysocialproject.presentation.ui.Theme.ProfilePictureSizeExtraSmall
import com.shubhans.googlysocialproject.presentation.ui.Theme.ProfilePictureSizeMedium
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceMedium
import com.shubhans.googlysocialproject.presentation.ui.Theme.TextWhite
import com.shubhans.googlysocialproject.presentation.ui.Theme.shapes
import com.shubhans.googlysocialproject.presentation.utils.Constants

@Composable
fun Post(
    post: Post,
    modifier: Modifier = Modifier,
    showProfileImage:Boolean =true,
    onPostClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SpaceMedium)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(
                    y = if (showProfileImage) {
                        ProfilePictureSizeExtraSmall / 2f
                    } else 0.dp
                )
                .clip(shape = shapes.medium)
                .shadow(5.dp)
                .background(MediumGray)
                .clickable { onPostClick() }
        ) {
            Image(
                painterResource(id = R.drawable.himalayamountain),
                contentDescription = "post image"
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceMedium)
            ) {
                ActionButton(username = "shubhanshu2451",
                    modifier = Modifier.fillMaxWidth(),
                    onLikeClick = { isLiked ->

                    },
                    onCommentClick = {

                    },
                    onshareClick = {

                    },
                    onUsernameClick = { username ->

                    }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                Text(
                    text = buildAnnotatedString {
                        append(post.description)
                        withStyle(
                            SpanStyle(
                                color = HintGray
                            )
                        ) {
                            append(
                                LocalContext.current.getString(
                                    R.string.read_more
                                )
                            )
                        }
                    },
                    style = MaterialTheme.typography.h1,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Constants.Max_Post_Description_Lines
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.liked_by_x_people,
                            post.likeCount
                        ),
                        style = TextStyle()
                    )
                    Text(
                        text = stringResource(
                            id = R.string.x_comments,
                            post.commentCount
                        ),
                        style = TextStyle()
                    )

                }

            }
        }
        if (showProfileImage) {
            Image(
                painterResource(id = R.drawable.profile_picture),
                contentDescription = "profile Image",
                modifier = Modifier
                    .size(ProfilePictureSizeMedium)
                    .clip(CircleShape)
                    .align(Alignment.TopCenter)
            )
        }
    }
    }



@Composable
fun EngagementClickButtom(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    iconSize: Dp = 30.dp,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    onshareClick: () -> Unit = {}
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically) {
        IconButton(
            onClick = { onLikeClick(isLiked) },
            modifier = Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = if (isLiked) {
                    Color.Red
                } else {
                    TextWhite
                },

                contentDescription = if (isLiked) {
                    stringResource(id = R.string.un_like)
                } else {
                    stringResource(id = R.string.li_ke)
                }
            )

        }
        Spacer(modifier = Modifier.width(SpaceMedium))
        IconButton(
            onClick = { onCommentClick() },
            modifier = Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription =
                stringResource(id = R.string.comment)
            )
        }
        Spacer(modifier = Modifier.width(SpaceMedium))
        IconButton(
            onClick = { (onshareClick()) },
            modifier = Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription =
                stringResource(id = R.string.share)
            )

        }

    }
}


@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    onshareClick: () -> Unit = {},
    username: String,
    onUsernameClick: (String) -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = username,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color(color = 0xFF08FF04)
            ),
            modifier = Modifier.clickable {
                onUsernameClick(username)
            }

        )
        EngagementClickButtom(
            onLikeClick = onLikeClick,
            onCommentClick = onCommentClick,
            onshareClick = onshareClick

        )

    }
}


