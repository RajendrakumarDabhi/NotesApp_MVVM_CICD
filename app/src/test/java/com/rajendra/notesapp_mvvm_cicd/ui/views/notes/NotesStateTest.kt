package com.rajendra.notesapp_mvvm_cicd.ui.views.notes

import com.rajendra.notesapp_mvvm_cicd.domain.model.Note
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class NotesStateTest {
    @Test
    fun `default NotesState has empty notes, isLoading false, and error null`() {
        val state = NotesState()
        assertEquals(emptyList<Note>(), state.notes)
        assertEquals(false, state.isLoading)
        assertNull(state.error)
    }

    @Test
    fun `NotesState copy updates fields correctly`() {
        val note = Note(1, "title", "desc", 123L)
        val state = NotesState().copy(notes = listOf(note), isLoading = true, error = "error")
        assertEquals(listOf(note), state.notes)
        assertEquals(true, state.isLoading)
        assertEquals("error", state.error)
    }
}

