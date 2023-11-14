package com.shubhans.googlysocialproject.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shubhans.googlysocialproject.MainActivity
import com.shubhans.googlysocialproject.presentation.utils.Constants
import com.shubhans.googlysocialproject.presentation.utils.Screen
import com.shubhans.googlysocialproject.ui.theme.GooglySocialProjectTheme
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
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

    private val testDispatcher =TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }
  @Test
    fun splashScreen_displaysAndDisappears() =testDispatcher.runBlockingTest {
        composeTestRule.setContent {
            GooglySocialProjectTheme {
                SplashScreen(
                    navController = navController,
                    dispatcher = testDispatcher
                )
            }
        }
        composeTestRule
            .onNodeWithContentDescription("Logo")
            .assertExists()

        testScheduler.apply { advanceTimeBy(Constants.Splash_screen_duration); runCurrent() }


        verify {
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)
        }

    }
}