package com.rajendra.notesapp_mvvm_cicd.ui.views.notes

import com.rajendra.notesapp_mvvm_cicd.domain.model.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

sealed class NotesEvent {
    data class DeleteNote(val note: Note): NotesEvent()
    data class AddNote(val title: String, val description: String): NotesEvent()
    data class UpdateNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
}
