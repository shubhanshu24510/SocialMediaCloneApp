package com.shubhans.googlysocialproject.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 40,
    maxLines: Int = 1,
    onValueChange: (String) -> Unit,
    showPasswordToggled: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    onToggledPasswordClick: (Boolean) -> Unit = {},
    error: String = "!",
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = text,
            maxLines = maxLines,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.h1
                )
            },
            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (showPasswordToggled) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }, singleLine = true,
            trailingIcon = {
                if (isPasswordToggleDisplayed) {
                    IconButton(onClick = {
                        onToggledPasswordClick(!showPasswordToggled)
                    }) {
                        Icon(
                            imageVector = if (showPasswordToggled) {
                                Icons.Filled.VisibilityOff
                            } else {
                                Icons.Filled.Visibility
                            },
                            tint = Color.White, contentDescription = null
                        )

                    }
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    testTag = "standard_test_field"
                }

        )
        if (error.isNotEmpty()) {
            Text(
                text = error,
                //  style = MaterialTheme.typography.Medium,
                color = Color.Red,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}





