package com.example.tm.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tm.screens.GroupsScreen
import com.example.tm.screens.SettingScreen
import com.example.tm.screens.TaskCreationScreen
import com.example.tm.screens.TaskScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    modifier: Modifier,
    createTask: ()  -> Unit
) {
    NavHost(navController = navHostController, startDestination = "task_screen", modifier = modifier ) {
        composable("task_screen") {
            TaskScreen (
                createTask = createTask,
                modifier = Modifier
            )
        }
        composable("groups_screen") {
            GroupsScreen()
        }
        composable("setting_screen") {
            SettingScreen()
        }
        composable("taskCreation_screen") {
            TaskCreationScreen()
        }
    }
}
