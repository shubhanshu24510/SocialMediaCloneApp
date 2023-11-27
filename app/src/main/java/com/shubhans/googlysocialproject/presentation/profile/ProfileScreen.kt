package com.shubhans.googlysocialproject.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shubhans.googlysocialproject.R
import com.shubhans.googlysocialproject.domain.m.model.User
import com.shubhans.googlysocialproject.presentation.components.Post
import com.shubhans.googlysocialproject.presentation.profile.components.BannerSection
import com.shubhans.googlysocialproject.presentation.profile.components.ProfileHeaderScreen
import com.shubhans.googlysocialproject.presentation.ui.Theme.ProfilePictureSizeLarge
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceMedium
import com.shubhans.googlysocialproject.presentation.ui.Theme.Spacesmall
import com.shubhans.googlysocialproject.presentation.utils.Screen
import com.shubhans.googlysocialproject.presentation.utils.toPx
@Composable
fun ProfileScreen(
    navController: NavController,
    profilePictureSize: Dp = ProfilePictureSizeLarge,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val lazyListState = rememberLazyListState()
    val toolbarState = viewModel.toolbarState
    val iconHorizontalCenterLength =
        (LocalConfiguration.current.screenWidthDp.dp.toPx() / 4f -
                (profilePictureSize / 4f).toPx() -
                Spacesmall.toPx()) / 2f
    val iconSizeExpanded = 35.dp
    val toolbarHeightCollapsed = 75.dp
    val imageCollapsedOffsetY = remember {
        (toolbarHeightCollapsed - profilePictureSize / 2f) / 2f
    }
    val iconCollapsedOffsetY = remember {
        (toolbarHeightCollapsed - iconSizeExpanded) / 2f
    }
    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 2.5f).dp
    val toolbarHeightExpanded = remember {
        bannerHeight + profilePictureSize
    }
    val maxOffset = remember {
        toolbarHeightExpanded - toolbarHeightCollapsed
    }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                if (delta > 0f && lazyListState.firstVisibleItemIndex != 0) {
                    return Offset.Zero
                }
                val newOffset = viewModel.toolbarState.value.toolbarOffsetY + delta
                viewModel.setToolBarOffsetY(
                    newOffset.coerceIn(
                        minimumValue = -maxOffset.toPx(),
                        maximumValue = 0f
                    )
                )
                viewModel.setExpandedRatio((viewModel.toolbarState.value.toolbarOffsetY + maxOffset.toPx()) / maxOffset.toPx())
                return Offset.Zero
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = lazyListState
        ) {
            item {
                Spacer(modifier = Modifier.height(toolbarHeightExpanded - profilePictureSize / 2f))
            }
            item {
                ProfileHeaderScreen(
                    user = User(
                        profilePictureUrl = "",
                        username = "shubhanshu2451",
                        description = "Belief in Yourself \n" + "Everything is possible in this universe",
                        followingCount = 350,
                        followerCount = 750,
                        postCount = 10
                    )
                )
            }
            items(13) {
                Spacer(modifier = Modifier.height(SpaceMedium))
                Post(
                    post = com.shubhans.googlysocialproject.domain.m.model.Post(
                        username = "shubhanshu2451",
                        imageUrl = "",
                        profilePictureUrl = "",
                        description = "Absolutely adore Quito! Nestled amid stunning mountains, this city captivates with its rich history",
                        likeCount = 150,
                        commentCount = 30
                    ),
                    showProfileImage = false,
                    onPostClick = {
                        navController.navigate(Screen.PostDetailsScreen.route)
                    },
                )
            }
        }
        Column(modifier = Modifier.align(Alignment.TopCenter)) {
            BannerSection(
                modifier = Modifier
                    .height(
                        (bannerHeight * toolbarState.value.expandedRatio).coerceIn(
                            minimumValue = toolbarHeightCollapsed,
                            maximumValue = bannerHeight
                        )
                    ),
                leftIconModifier = Modifier
                    .graphicsLayer {
                        translationY = (1f - toolbarState.value.expandedRatio) *
                                -iconCollapsedOffsetY.toPx()
                        translationX = (1f - toolbarState.value.expandedRatio) *
                                iconHorizontalCenterLength
                    },
                rightIconModifier = Modifier
                    .graphicsLayer {
                        translationY = (1f - toolbarState.value.expandedRatio) *
                                -iconCollapsedOffsetY.toPx()
                        translationX = (1f - toolbarState.value.expandedRatio) *
                                -iconHorizontalCenterLength
                    },

                )
            Image(painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = stringResource(id = R.string.profile_image),
                modifier = Modifier
                    .align(CenterHorizontally)
                    .graphicsLayer {
                        translationY = -profilePictureSize.toPx() / 2f -
                                (1f - toolbarState.value.expandedRatio) * imageCollapsedOffsetY.toPx()
                        transformOrigin = TransformOrigin(
                            pivotFractionX = 0.5f,
                            pivotFractionY = 0f
                        )
                        val scale = 0.5f + toolbarState.value.expandedRatio * 0.5f
                        scaleX = scale
                        scaleY = scale
                    }
                    .size(profilePictureSize)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onSurface,
                        shape = CircleShape
                    )
            )
        }
    }
}



