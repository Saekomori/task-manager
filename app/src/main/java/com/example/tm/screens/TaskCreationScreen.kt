package com.example.tm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tm.bottom_navigation.BottomNavigationBar
import com.example.tm.ui.theme.components.ButtonTask
import com.example.tm.ui.theme.components.CustomDatePicker
import com.example.tm.ui.theme.components.MainAppBar
import com.example.tm.ui.theme.components.SubtaskAdd
import com.example.tm.ui.theme.components.SubtaskText
import com.example.tm.ui.theme.components.TaskText
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun TaskCreationScreen() {
    val topBarTitle = remember { mutableStateOf("") }
    val taskName = remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    val subTasks = remember { mutableStateListOf<String>() }
    val newSubTaskText = remember { mutableStateOf("") }
    val selectedDates = remember { mutableStateOf<List<LocalDate>>(listOf()) }
    val disabledDates = listOf(
        LocalDate.now().minusDays(7),
        LocalDate.now().minusDays(12),
        LocalDate.now().plusDays(3),
    )

    val state = rememberUseCaseState(visible = true)
    topBarTitle.value = "New task"

    Scaffold(
        modifier = androidx.compose.ui.Modifier.safeDrawingPadding(),
        topBar = {
            MainAppBar(title = topBarTitle.value)
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White
            ) {
                Row(
                    modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    ButtonTask(text = "Cancel") {

                    }
                    ButtonTask(text = "Save") {

                    }
                }
            }
        }
        ) { innerPadding ->
        
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(10.dp)
                ) {
                    RadioButton(selected = false, onClick = { })
                    TaskText(
                        text = "taskName",
                        placeholder = "Title",
                        label = "",
                        onTextChanged = {newText -> taskName.value = newText},
                        modifier = Modifier
                            .height(15.dp)
                            .fillMaxWidth()

                    )
                }
                for (task in subTasks) {
                    SubtaskText(text = task)
                }
                SubtaskAdd{newSubTask -> subTasks.add(newSubTask)}
                val date = remember { mutableStateOf(LocalDate.now())}
                CustomDatePicker(
                    value = date.value,
                    onValueChange = {date.value = it}
                )




            }
        }
    }
}
