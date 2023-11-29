package com.shubhans.googlysocialproject.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceLarge
import com.shubhans.googlysocialproject.presentation.ui.Theme.SpaceMedium

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()
        .padding(start = SpaceLarge,
            end = SpaceLarge,
            top = SpaceLarge,
            bottom = 50.dp)) {
        Column(
            modifier = Modifier
                .padding(SpaceMedium)
                .align(Alignment.Center)
        ) {
            Text(
                text = stringResource(id = R.string.Register),
                style = MaterialTheme.typography.h1
            )

            Spacer(modifier = Modifier.height(SpaceMedium))

            StandardTextField(
                text = viewModel.emailText.value,
                error = viewModel.emailError.value,
                onValueChange = { viewModel.setEmailText(it) },
                hint = stringResource(id = R.string.Email),
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(SpaceMedium))

            StandardTextField(
                    text = viewModel.usernameText.value,
                error = viewModel.UsernameError.value,
            onValueChange = { viewModel.setUserNameText(it) },
            hint = stringResource(id = R.string.Username)
            )

            Spacer(modifier = Modifier.height(SpaceMedium))

            StandardTextField(
                text = viewModel.passwordText.value,
                hint = stringResource(id = R.string.password_hint),
                onValueChange = {
                    viewModel.setPasswordText(it) },
                isPasswordVisible = viewModel.showPassword.value,
                error = viewModel.passwordError.value,
                onPasswordToggleClick ={
                    viewModel.setshowPassword(it)

                },
                keyboardType = KeyboardType.Password
            )
        }
        Text(text = buildAnnotatedString {
            append(stringResource(id = R.string.already_have_an_account))
            append(" ")
            val signupText = stringResource(id = R.string.Log_in)
            withStyle(style = SpanStyle( color = MaterialTheme.colors.primary)
            ){
                append(signupText)
            }
        },
            style = MaterialTheme.typography.h1,
            modifier = Modifier.align(Alignment.BottomCenter)
                .clickable {
                    navController.popBackStack()
                }
        )

    }
}
