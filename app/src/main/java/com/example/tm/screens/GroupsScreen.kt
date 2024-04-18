package com.example.tm.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tm.ui.theme.components.ButtonAuth

@Composable
fun GroupsScreen() {
    Text(text = "НАА",
        modifier = Modifier.fillMaxSize().wrapContentHeight())
    ButtonAuth(text = "tefgggggggggggggggggg") {
        Log.d("TaskScreen", "Button clicked")
    }
}