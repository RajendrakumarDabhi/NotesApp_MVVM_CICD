package com.rajendra.notesapp_mvvm_cicd.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.rajendra.notesapp_mvvm_cicd.ui.views.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewmmodel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme(darkTheme = viewmmodel.isDark.value) {
                Scaffold(
                    modifier = Modifier,
                    topBar = {
                        TopAppBar(
                            // You can set a navigation icon if needed
                            actions = {
                                Image(
                                    imageVector = Icons.Default.ColorLens,
                                    contentDescription = "Back",
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .clickable {
                                            viewmmodel.toggleTheme()
                                        }
                                )
                            },
                            title = { Text("Notes") },
                        )
                    },
                    content = {
                        NotesNavHost()
                    })
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

