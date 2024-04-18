package com.example.tm.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingScreen() {
    Text(text = "НАСТРОЙКИ",
        modifier = Modifier.fillMaxSize().wrapContentHeight())

}