package com.shubhans.googlysocialproject.presentation.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shubhans.googlysocialproject.MainActivity
import com.shubhans.googlysocialproject.ui.theme.GooglySocialProjectTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StandardTextFieldTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            var text by remember {
                mutableStateOf("")
            }
            GooglySocialProjectTheme {
                StandardTextField(
                    text = text,
                    onValueChange = { text = it },
                    maxLength = 5,
                    modifier = Modifier.semantics {
                        testTag = "standard_text_field"
                    })
            }

        }

    }

    @Test
    fun enterTooLonString_maxLengthNotExceeded() {
        val expectedString = "sssss"
        composeTestRule
            .onNodeWithTag("standard_text_field")
            .performTextClearance()

        composeTestRule
            .onNodeWithTag("standard_text_field")
            .performTextInput(expectedString)
        composeTestRule
            .onNodeWithTag("standard_text_field")
            .performTextInput("s")
        composeTestRule
            .onNodeWithTag("standard_text_field")
            .assertTextEquals(expectedString)


    }
}


