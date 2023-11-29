package com.shubhans.googlysocialproject.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shubhans.googlysocialproject.R
import com.shubhans.googlysocialproject.presentation.components.StandardTextField
import com.shubhans.googlysocialproject.presentation.utils.Screen
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceLarge
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceMedium


@Composable
fun LoginScreen(
    navController: NavController,
                viewModel: LoginViewModel = hiltViewModel()) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = SpaceLarge,
            end = SpaceLarge,
            top = SpaceLarge,
            bottom = 50.dp
        )) {
        Column(
            modifier = Modifier
                .padding(SpaceMedium)
                .align(Alignment.Center)
        ) {
            Text(
                text = stringResource(id = R.string.Log_in),
                style = MaterialTheme.typography.h2
            )

            Spacer(modifier = Modifier.height(SpaceMedium))

            StandardTextField(
                text = viewModel.usernameText.value,
                onValueChange = { viewModel.setUserNameText(it) },
                error = viewModel.isUsernameError.value,
                hint = stringResource(id = R.string.username_hint),
                keyboardType = KeyboardType.Email)

            Spacer(modifier = Modifier.height(SpaceMedium))

            StandardTextField(
                text = viewModel.passwordText.value,
                hint = stringResource(id = R.string.password_hint),
                onValueChange = {
                    viewModel.setPasswordText(it) },
                isPasswordVisible = viewModel.showPassword.value,
                error = viewModel.isPasswordError.value,
                onPasswordToggleClick ={
                    viewModel.setshowPassword(it)
                },
                keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(SpaceMedium))

            Button(
                onClick = { navController.navigate(Screen.MainFeedScreen.route) },
                modifier = Modifier
                    .align(Alignment.End)) {
                Text(text = stringResource(id = R.string.Log_in),
                    color = MaterialTheme.colors.onPrimary)

            }

        }
        Text(text = buildAnnotatedString {
            append(stringResource(id = R.string.do_not_have_account_yet))
            append(" ")
            val signupText = stringResource(id = R.string.sign_up)
            withStyle(style = SpanStyle( color =MaterialTheme.colors.primary)
            ){
                append(signupText)
            }
        },
            style = MaterialTheme.typography.h1,
            modifier = Modifier.align(Alignment.BottomCenter)
                .clickable {
                    navController.navigate(Screen.RegisterScreen.route)
                }
        )

    }
}





