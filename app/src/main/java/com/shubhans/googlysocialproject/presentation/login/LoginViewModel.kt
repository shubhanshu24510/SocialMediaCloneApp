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

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _isusernameError = mutableStateOf("")
    val isUsernameError: State<String> = _isusernameError

    private val _ispasswordError = mutableStateOf("")
    val isPasswordError: State<String> = _ispasswordError

    fun setUserNameText(username: String) {
        _username.value = username
    }
    fun setPasswordText(password: String) {
        _password.value = password
    }

    fun setshowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword

    }
    fun setisUsernameError(error: String) {
        _isusernameError.value = error

    }
    fun setisPasswordError(error: String) {
        _ispasswordError.value = error

    }


}