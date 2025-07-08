package com.rajendra.notesapp_mvvm_cicd.ui.views

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class MainViewModelTest {
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun `default theme is light`() {
        assertFalse(viewModel.isDark.value)
    }

    @Test
    fun `toggleTheme switches theme`() {
        val initial = viewModel.isDark.value
        viewModel.toggleTheme()
        assertTrue(viewModel.isDark.value != initial)
    }
}

