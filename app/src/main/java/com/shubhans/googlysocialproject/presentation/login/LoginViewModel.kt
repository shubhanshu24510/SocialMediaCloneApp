package com.shubhans.googlysocialproject.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _username = mutableStateOf("")
    val usernameText: State<String> = _username
    private val _password = mutableStateOf("")
    val passwordText: State<String> = _password

    fun setUserNameText(username: String) {
        _username.value = username
    }
    fun setPasswordText(password: String) {
        _password.value = password

    }


}