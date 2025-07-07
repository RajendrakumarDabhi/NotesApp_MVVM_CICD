package com.rajendra.notesapp_mvvm_cicd.ui.views

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _isDark = mutableStateOf(false)
    val isDark: MutableState<Boolean> = _isDark

    fun toggleTheme() {
        _isDark.value = !_isDark.value
    }
    
}