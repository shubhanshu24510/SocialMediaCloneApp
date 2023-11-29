package com.shubhans.googlysocialproject.presentation.profile_edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.shubhans.googlysocialproject.presentation.utils.StandardTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel  @Inject constructor(): ViewModel() {
    
    private val _usernameState = mutableStateOf(StandardTextFieldState())
    val usernameState:State<StandardTextFieldState> = _usernameState

    private val _linkedInState = mutableStateOf(StandardTextFieldState())
    val linkedInState:State<StandardTextFieldState> = _linkedInState

    private val _gitHubState = mutableStateOf(StandardTextFieldState())
    val GitHubState:State<StandardTextFieldState> = _gitHubState


     private val _instragramState = mutableStateOf(StandardTextFieldState())
    val instragramState:State<StandardTextFieldState> = _instragramState

    private val _biographyState = mutableStateOf(StandardTextFieldState())
    val biographyState:State<StandardTextFieldState> = _biographyState
    fun setusernameState (state: StandardTextFieldState){
        _usernameState.value =state
    }
    fun setLinkedInstate (state: StandardTextFieldState){
        _linkedInState.value =state
    }
    fun setGitHubState (state: StandardTextFieldState){
      _gitHubState.value =state
    }
    fun setinstragramState (state: StandardTextFieldState){
        _instragramState.value =state
    }
    fun setBioGraphyState (state: StandardTextFieldState){
        _biographyState.value =state
    }
}