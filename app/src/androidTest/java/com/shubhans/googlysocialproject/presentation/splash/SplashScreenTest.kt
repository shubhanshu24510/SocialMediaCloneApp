package com.shubhans.googlysocialproject.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shubhans.googlysocialproject.MainActivity
import com.shubhans.googlysocialproject.ui.theme.GooglySocialProjectTheme
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SplashScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }
    @Test
    fun splashScreen_displaysAndDisappears() {
        composeTestRule.setContent {
            GooglySocialProjectTheme {
                SplashScreen(
                    navController = navController
                )
            }
        }
        composeTestRule
            .onNodeWithContentDescription("Logo")
            .assertExists()

    }
}