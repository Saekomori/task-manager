package com.example.tm.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment


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
                 },
            ) {
            Icon(Icons.Filled.Add, contentDescription = "Добавление")
        }
        OutlinedTextField(value = textFieldValue,
            onValueChange = { newValue ->
                textFieldValue = newValue
            },
        )
    }
}

@Composable
fun SubtaskText(text: String,
                onTextChanged: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
        ) {
        RadioButton(selected = false, onClick = { /*TODO*/ })
        OutlinedTextField(value = text,
            onValueChange = {  onTextChanged(it) },
        )
    }
}