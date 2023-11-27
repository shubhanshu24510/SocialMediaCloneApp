package com.shubhans.googlysocialproject.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shubhans.googlysocialproject.R
import com.shubhans.googlysocialproject.domain.m.model.User
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceExtraLarge
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceLarge

@Composable
fun ProfileStatus(
    modifier: Modifier =Modifier,
    user: User,
    isFollowing:Boolean =true,
    isOwnProfile:Boolean =true,
    onFollowClick:() ->Unit ={}

){
    Row (modifier =modifier.padding(top = 10.dp)){
        Profilenumber(number = user.followerCount,
            text = stringResource(id = R.string.followers))

        Spacer(modifier = Modifier.height(SpaceExtraLarge))
        Profilenumber(number = user.followingCount,
            text = stringResource(id = R.string.following))

        Spacer(modifier = Modifier.height(SpaceExtraLarge))
        Profilenumber(number = user.postCount,
            text = stringResource(id = R.string.posts))
        Spacer(modifier = Modifier.height(SpaceExtraLarge))
        Row(modifier = Modifier.padding(start = 30.dp)){
            if(isOwnProfile) {
                Button(
                    onClick = onFollowClick,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (isFollowing) {
                            Color.Red
                        } else MaterialTheme.colors.primary
                    )
                ) {
                    Text(
                        text = if (isFollowing) {
                            stringResource(id = R.string.un_follow)
                        } else stringResource(id = R.string.fo_llow),
                        color = if (isFollowing) {
                            Color.White
                        } else MaterialTheme.colors.onPrimary
                    )
                }
            }

        }
    }
}