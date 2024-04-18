package com.example.tm.screens
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tm.ui.theme.components.ButtonFab


@Composable
fun TaskScreen(
    modifier: Modifier = Modifier,
    createTask: () -> Unit
){

    Scaffold(
        floatingActionButton = {
            ButtonFab { createTask() }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) { padding ->

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = modifier
        ) {
            itemsIndexed(
                listOf("item 1", "item 2", "item 3", "item 1", "item 2", "item 3", "item 1", "item 2", "item 3","item 1", "item 2", "item 3","item 1", "item 2", "item 3", "item 1", "item 2", "item 3", "item 1", "item 2", "item 3", "item 1", "item 2", "item 3", "item 1", "item 2", "item 3")
            ) { index, item ->
                Text(
                    text = "Item $index",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }

        }
    }


}