package com.example.tm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.example.tm.ui.theme.components.ButtonAuth
import com.example.tm.ui.theme.components.MyOutlinedTextField
import com.example.tm.ui.theme.components.PasswordOutlinedTextField


@Composable
fun AuthScreen(
    regGoClick: () -> Unit,
    loginClick: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var taskName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column (
      modifier = Modifier
          .fillMaxSize()
          .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyOutlinedTextField(text = email, placeholder = "Email", label = "Email", onTextChanged = { newText ->
            email = newText}, keyboardType = KeyboardType.Email,
        )
        PasswordOutlinedTextField(text = password, placeholder = "Password", label = "Password", onTextChanged = { newText ->
            password = newText}, keyboardType = KeyboardType.Password, isPassword = true,
        )
        ButtonAuth(text = "Log in") {
            loginClick()
        }
        ButtonAuth(text = "Go to registration" ) {
            regGoClick()
        }

    }
}