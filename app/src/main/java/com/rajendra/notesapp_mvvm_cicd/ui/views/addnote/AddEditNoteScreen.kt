package com.rajendra.notesapp_mvvm_cicd.ui.views.addnote

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rajendra.notesapp_mvvm_cicd.R
import com.rajendra.notesapp_mvvm_cicd.ui.views.notes.NotesEvent
import com.rajendra.notesapp_mvvm_cicd.ui.views.notes.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteScreen(
    navController: NavController,
    noteId: Int?,
    viewModel: NotesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val note = state.notes.find { it.id == noteId }
    var title by remember { mutableStateOf(TextFieldValue(note?.title ?: "")) }
    var description by remember { mutableStateOf(TextFieldValue(note?.description ?: "")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (noteId == null) stringResource(id = R.string.add_note) else stringResource(id = R.string.edit_note)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = stringResource(id = R.string.back))
                    }
                },
                actions = {
                    IconButton(onClick = {
                        if (noteId == null) {
                            viewModel.onEvent(NotesEvent.AddNote(title.text, description.text))
                        } else {
                            viewModel.onEvent(
                                NotesEvent.UpdateNote(
                                note!!.copy(title = title.text, description = description.text)
                            ))
                        }
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Default.Check, contentDescription = stringResource(id = R.string.save))
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text(stringResource(id = R.string.title)) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text(stringResource(id = R.string.description)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
        }
    }
}
