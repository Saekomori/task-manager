
package com.example.tm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.tm.bottom_navigation.BottomNavigationBar
import com.example.tm.graphs.NavGraph
import com.example.tm.ui.theme.components.MainAppBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(createTask: () -> Unit) {
    val navController = rememberNavController()
    val topBarTitle = remember {
        mutableStateOf("")
    }

    topBarTitle.value = "Menu"
    Scaffold (
        modifier = Modifier.safeDrawingPadding(),
        topBar = {
            MainAppBar(title = topBarTitle.value)
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
            NavGraph(navHostController = navController,
                modifier = Modifier
                    .padding(innerPadding),
                createTask = createTask
            )
    }
}