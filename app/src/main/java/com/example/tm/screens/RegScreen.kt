package com.example.tm.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.tm.ui.theme.components.ButtonAuth
import com.example.tm.ui.theme.components.MyOutlinedTextField
import com.example.tm.ui.theme.components.PasswordOutlinedTextField


@Composable
fun RegScreen(
    authGo: () -> Unit,
    tasksGo: () -> Unit
){
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordRepeat by rememberSaveable { mutableStateOf("") }
    var username by rememberSaveable { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyOutlinedTextField(text = email, placeholder = "Email", label = "Email", onTextChanged = { newText ->
            email = newText }, keyboardType = KeyboardType.Password
        )
        MyOutlinedTextField(text = username, placeholder = "Username", label = "Username", onTextChanged = { newText ->
            username = newText }, keyboardType = KeyboardType.Text
        )
        PasswordOutlinedTextField(text = password, placeholder = "Password", label = "Password", onTextChanged = { newText ->
            password = newText }, keyboardType = KeyboardType.Password
        )
        PasswordOutlinedTextField(text = passwordRepeat, placeholder = "Repeat password", label = "Repeat password", onTextChanged = { newText ->
            passwordRepeat = newText }, keyboardType = KeyboardType.Password)
        ButtonAuth(text = "Sign in") {
            tasksGo()
        }
        ButtonAuth(text = "Back") {
            authGo()
        }
    }
}