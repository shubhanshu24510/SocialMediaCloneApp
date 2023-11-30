package com.shubhans.googlysocialproject.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.shubhans.googlysocialproject.presentation.utils.StandardTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {
    private val _serchStateText = mutableStateOf(StandardTextFieldState())
    val serchStateText: State<StandardTextFieldState> = _serchStateText

    fun setSearchfieldState(state: StandardTextFieldState) {
        _serchStateText.value = state
    }
}