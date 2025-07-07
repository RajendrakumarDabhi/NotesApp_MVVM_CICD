package com.rajendra.notesapp_mvvm_cicd.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rajendra.notesapp_mvvm_cicd.ui.views.addnote.AddEditNoteScreen
import com.rajendra.notesapp_mvvm_cicd.ui.views.notes.NotesScreen
import com.rajendra.notesapp_mvvm_cicd.ui.theme.NotesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                Surface(modifier = Modifier) {
                    NotesNavHost()
                }
            }
        }
    }
}

@Composable
fun NotesNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "notes"
    ) {
        composable("notes") {
            NotesScreen(
                onAddNote = { navController.navigate("addEditNote") },
                onNoteClick = { noteId -> navController.navigate("addEditNote?noteId=$noteId") }
            )
        }
        composable(
            route = "addEditNote?noteId={noteId}",
            arguments = listOf(
                navArgument("noteId") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId")?.takeIf { it != -1 }
            AddEditNoteScreen(
                navController = navController,
                noteId = noteId
            )
        }
    }
}

