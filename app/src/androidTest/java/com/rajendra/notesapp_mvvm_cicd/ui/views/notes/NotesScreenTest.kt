package com.rajendra.notesapp_mvvm_cicd.ui.views.notes

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rajendra.notesapp_mvvm_cicd.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotesScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun notesScreen_displaysAddNoteButton() {
        composeTestRule.onNodeWithText("Add Note").assertExists()
    }
}

