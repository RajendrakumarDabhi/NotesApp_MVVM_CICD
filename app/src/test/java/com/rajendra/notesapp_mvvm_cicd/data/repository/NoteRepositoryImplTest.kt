package com.rajendra.notesapp_mvvm_cicd.data.repository

import com.rajendra.notesapp_mvvm_cicd.data.local.NoteDao
import com.rajendra.notesapp_mvvm_cicd.domain.model.Note
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NoteRepositoryImplTest {
    private lateinit var noteDao: NoteDao
    private lateinit var repository: NoteRepositoryImpl

    @Before
    fun setUp() {
        noteDao = mockk(relaxed = true)
        repository = NoteRepositoryImpl(noteDao)
    }

    @Test
    fun `getNotes returns flow of notes`() = runTest {
        val notes = listOf(Note(1, "title", "desc", 123L))
        coEvery { noteDao.getNotes() } returns flowOf(notes)
        val result = repository.getNotes()
        assertNotNull(result)
    }

    @Test
    fun `getNoteById returns note`() = runTest {
        val note = Note(1, "title", "desc", 123L)
        coEvery { noteDao.getNoteById(1) } returns note
        val result = repository.getNoteById(1)
        assertEquals(note, result)
    }

    @Test
    fun `insertNote calls dao`() = runTest {
        val note = Note(1, "title", "desc", 123L)
        repository.insertNote(note)
        coVerify { noteDao.insertNote(note) }
    }

    @Test
    fun `deleteNote calls dao`() = runTest {
        val note = Note(1, "title", "desc", 123L)
        repository.deleteNote(note)
        coVerify { noteDao.deleteNote(note) }
    }

    @Test
    fun `updateNote calls dao`() = runTest {
        val note = Note(1, "title", "desc", 123L)
        repository.updateNote(note)
        coVerify { noteDao.updateNote(note) }
    }
}
