package com.example.tm.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SubtaskAdd(onAddSubtaskClick: (String) -> Unit) {
    var textFieldValue by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = {
                onAddSubtaskClick(textFieldValue)
                textFieldValue = "" },
            ) {
            Icon(Icons.Filled.Add, contentDescription = "Добавление")
        }
        TextField(value = textFieldValue,
            onValueChange = { newValue ->
                textFieldValue = newValue
            },
            modifier = Modifier.height(10.dp)
        )
    }
}

@Composable
fun SubtaskText(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
        ) {
        RadioButton(selected = false, onClick = { /*TODO*/ })
        TextField(value = "",
            onValueChange = {  },
            modifier = Modifier.height(10.dp)
        )
    }
}