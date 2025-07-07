package com.rajendra.notesapp_mvvm_cicd.data.repository

import com.rajendra.notesapp_mvvm_cicd.data.local.NoteDao
import com.rajendra.notesapp_mvvm_cicd.domain.model.Note
import com.rajendra.notesapp_mvvm_cicd.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> = dao.getNotes()

    override suspend fun getNoteById(id: Int): Note? = dao.getNoteById(id)

    override suspend fun insertNote(note: Note) = dao.insertNote(note)

    override suspend fun deleteNote(note: Note) = dao.deleteNote(note)

    override suspend fun updateNote(note: Note) = dao.updateNote(note)
}
