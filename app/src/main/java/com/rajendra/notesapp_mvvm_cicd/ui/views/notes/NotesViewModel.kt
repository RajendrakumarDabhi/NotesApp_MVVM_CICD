package com.rajendra.notesapp_mvvm_cicd.ui.views.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajendra.notesapp_mvvm_cicd.domain.model.Note
import com.rajendra.notesapp_mvvm_cicd.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    private val _state = MutableStateFlow(NotesState())
    val state: StateFlow<NotesState> = _state.asStateFlow()

    private var recentlyDeletedNote: Note? = null

    init {
        getNotes()
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    repository.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    recentlyDeletedNote?.let { note ->
                        repository.insertNote(note)
                        recentlyDeletedNote = null
                    }
                }
            }
            is NotesEvent.AddNote -> {
                viewModelScope.launch {
                    repository.insertNote(
                        Note(
                            title = event.title,
                            description = event.description
                        )
                    )
                }
            }
            is NotesEvent.UpdateNote -> {
                viewModelScope.launch {
                    repository.updateNote(event.note)
                }
            }
        }
    }

    private fun getNotes() {
        repository.getNotes()
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes
                )
            }
            .launchIn(viewModelScope)
    }
}
