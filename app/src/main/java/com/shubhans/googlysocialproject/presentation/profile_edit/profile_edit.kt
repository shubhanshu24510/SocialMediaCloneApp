package com.shubhans.googlysocialproject.presentation.profile_edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.shubhans.googlysocialproject.R
import com.shubhans.googlysocialproject.presentation.components.StandardTextField
import com.shubhans.googlysocialproject.presentation.components.StandardTopToolBar
import com.shubhans.googlysocialproject.presentation.ui.Theme.ProfilePictureSizeLarge
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceLarge
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceMedium
import com.shubhans.googlysocialproject.presentation.utils.StandardTextFieldState
import kotlin.random.Random
@Composable
fun ProfileEditScreen(
    navController: NavHostController,
    profillePictireSize: Dp = ProfilePictureSizeLarge,
    viewModel: EditProfileViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardTopToolBar(
            modifier = Modifier.fillMaxWidth(),
            navController = navController,
            showBackArrow = true,
            navActions = {
                         IconButton(onClick = { /*TODO*/ }) {
                             Icon(imageVector = Icons.Default.Check,
                                 contentDescription = stringResource(id = R.string.check_mark),
                                 tint = MaterialTheme.colors.primary)

                         }
            },
            title = {
                Text(
                    text =
                    stringResource(id = R.string.edit_your_profile),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            BannerEditSection(
                bannerImage = painterResource(id = R.drawable.cover_photo),
                profileImage = painterResource(id = R.drawable.profile_picture),
                profilePictureSize = profillePictireSize
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(SpaceLarge)
            ) {
                Spacer(modifier = Modifier.height(SpaceLarge))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    hint = stringResource(id = R.string.user_name),
                    text = viewModel.usernameState.value.text,
                    error = viewModel.usernameState.value.error,
                    onValueChange = {
                        viewModel.setusernameState(StandardTextFieldState(text = it))
                    },
                    leadingIcon = Icons.Default.Person
                )
                Spacer(modifier = Modifier.height(SpaceLarge))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    hint = stringResource(id = R.string.instragram),
                    text = viewModel.linkedInState.value.text,
                    error = viewModel.linkedInState.value.error,
                    onValueChange = {
                        viewModel.setLinkedInstate(StandardTextFieldState(text = it))
                    },
                    leadingIcon = ImageVector.vectorResource(R.drawable.linkedin_icon)
                )
                Spacer(modifier = Modifier.height(SpaceLarge))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    hint = stringResource(id = R.string.github),
                    text = viewModel.GitHubState.value.text,
                    error = viewModel.GitHubState.value.error,
                    onValueChange = {
                        viewModel.setGitHubState(StandardTextFieldState(text = it))
                    },
                    leadingIcon = ImageVector.vectorResource(R.drawable.github_icon)
                )
                Spacer(modifier = Modifier.height(SpaceLarge))

                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    hint = stringResource(id = R.string.github),
                    text = viewModel.instragramState.value.text,
                    error = viewModel.instragramState.value.error,
                    onValueChange = {
                        viewModel.setinstragramState(StandardTextFieldState(text = it))
                    },
                    leadingIcon = ImageVector.vectorResource(R.drawable.instagram_2016_5)
                )
                Spacer(modifier = Modifier.height(SpaceLarge))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    hint = stringResource(id = R.string.your_bio),
                    text = viewModel.biographyState.value.text,
                    error = viewModel.biographyState.value.error,
                    singleLine = false,
                    maxLines = 3,
                    onValueChange = {
                        viewModel.setBioGraphyState(StandardTextFieldState(text = it))
                    },
                )
                Spacer(modifier = Modifier.height(SpaceLarge))
                Text(text = stringResource(id = R.string.select_top_3_skills),
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                Spacer(modifier = Modifier.height(SpaceLarge))
                com.google.accompanist.flowlayout.FlowRow(modifier = Modifier.fillMaxWidth(),
                 mainAxisAlignment = MainAxisAlignment.Center,
                 mainAxisSpacing = SpaceMedium,
                 crossAxisSpacing = SpaceMedium){
                    listOf(
                        "Python",
                        "Java",
                        "JavaScript",
                        "Ruby",
                        "Swift",
                        "C++",
                        "Kotlin",
                        "C#",
                        "GoLang",
                        "SQL",
                        "TypeScript",
                        "Objective-C",
                        "Dart",
                        "PHP"
                    ).forEach {
                        com.shubhans.googlysocialproject.presentation.profile_edit.Components.Chip(
                            text = it,
                            selected = Random.nextInt(2) ==0
                        ) {
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BannerEditSection(
    bannerImage: Painter,
    profileImage: Painter,
    profilePictureSize: Dp = ProfilePictureSizeLarge,
    onBannerClick: () -> Unit = {},
    onProfileImageClick: () -> Unit = {}
) {
    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 2.5f).dp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(bannerHeight + profilePictureSize / 2f)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(bannerHeight),
            painter = bannerImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Image(
            painter = profileImage,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
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