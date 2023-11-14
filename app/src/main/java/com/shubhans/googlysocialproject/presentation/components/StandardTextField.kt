package com.shubhans.googlysocialproject.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardTextField(
    modifier: Modifier =Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 40,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val isPasswordToggleDisplayed by remember {
        mutableStateOf(keyboardType == KeyboardType.Password)
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    TextField(
        value = text, onValueChange = {
            if (it.length < maxLength) {
                onValueChange(it)
            }
        },
        placeholder = {
            Text(text = hint)
        },
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        visualTransformation = if (isPasswordVisible) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }, singleLine = true,
        trailingIcon = {
            if (isPasswordToggleDisplayed) {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) {
                            Icons.Filled.VisibilityOff
                        } else {
                            Icons.Filled.Visibility
                        }, contentDescription = null
                    )

                }
            }


        },
        modifier = modifier.fillMaxWidth()

    )
}




