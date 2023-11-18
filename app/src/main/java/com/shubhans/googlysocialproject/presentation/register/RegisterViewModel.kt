package com.shubhans.googlysocialproject.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
    private val _username = mutableStateOf("")
    val usernameText: State<String> = _username

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _password = mutableStateOf("")
    val passwordText: State<String> = _password

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

private val _emailError = mutableStateOf("")
    val emailError: State<String> = _emailError

    private val _usernameError = mutableStateOf("")
    val UsernameError: State<String> = _usernameError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    fun setUserNameText(username: String) {
        _username.value = username
    }
    fun setEmailText(email: String) {
        _emailText.value = email
    }
    fun setPasswordText(password: String) {
        _password.value = password
    }
    fun setshowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword

    }
    fun setisUsernameError(error: String) {
        _usernameError.value = error

    }
    fun setEmailError(error: String) {
        _emailError.value = error

    }
    fun setPasswordError(error: String){
        _passwordError.value =error
    }
}