package com.shubhans.googlysocialproject.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.shubhans.googlysocialproject.ui.theme.SpaceLarge
import com.shubhans.googlysocialproject.ui.theme.SpaceMedium


@Composable
fun LoginScreen(
    navController: NavController,
                viewModel: LoginViewModel = hiltViewModel()) {
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
                text = stringResource(id = R.string.Log_in),
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(SpaceMedium))

            StandardTextField(
                text = viewModel.usernameText.value,
                onValueChange = { viewModel.setUserNameText(it) },
                hint = stringResource(id = R.string.username_hint)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))

            StandardTextField(
                text = viewModel.passwordText.value,
                onValueChange = { viewModel.setPasswordText(it) },
                hint = stringResource(id = R.string.password_hint),
                keyboardType = KeyboardType.Password
            )
        }
        Text(text = buildAnnotatedString {
            append(stringResource(id = R.string.do_not_have_account_yet))
            append(" ")
            val signupText = stringResource(id = R.string.sign_up)
            withStyle(style = SpanStyle( color =MaterialTheme.colorScheme.primary)
            ){
                append(signupText)
            }
        },
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

    }
}





