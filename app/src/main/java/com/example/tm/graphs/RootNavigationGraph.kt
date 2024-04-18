package com.example.tm.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tm.screens.MainScreen
import com.example.tm.screens.TaskCreationScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController)

        composable(route = Graph.MAIN) {
             MainScreen(
                 createTask = {navController.navigate(Graph.TASK)}
             )
        }
        composable(route = Graph.TASK) {
            TaskCreationScreen()
        }

    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val MAIN = "main_graph"
    const val DETAILS = "details_graph"
    const val TASK = "task_graph"
}