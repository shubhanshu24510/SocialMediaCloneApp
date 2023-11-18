package com.shubhans.googlysocialproject.presentation.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StandardSccafoldViewModel @Inject constructor():ViewModel(){

    private val  _selectedBottomNavItem = mutableStateOf(0)
    val selectedBottomNavItem:State<Int> =_selectedBottomNavItem

    fun setselectedBottomNavItem(item: Int){
        _selectedBottomNavItem.value =item
    }
}