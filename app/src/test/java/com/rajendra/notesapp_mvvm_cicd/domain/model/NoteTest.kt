package com.rajendra.notesapp_mvvm_cicd.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test

class NoteTest {
    @Test
    fun `note data class equality works`() {
        val note1 = Note(1, "title", "desc", 123L)
        val note2 = Note(1, "title", "desc", 123L)
        assertEquals(note1, note2)
    }

    @Test
    fun `note data class copy works`() {
        val note1 = Note(1, "title", "desc", 123L)
        val note2 = note1.copy(title = "new title")
        assertEquals("new title", note2.title)
        assertEquals(note1.id, note2.id)
    }
}

