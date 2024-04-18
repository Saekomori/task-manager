package com.example.tm.ui.theme.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.tm.R

@Composable
fun MyOutlinedTextField(
    text: String,
    placeholder: String,
    label: String,
    onTextChanged: (String) -> Unit,
    keyboardType: KeyboardType,
    isPassword: Boolean = false,
    modifier: Modifier = Modifier
        .padding(16.dp),
) {
    OutlinedTextField(
        value = text,
        onValueChange = {  onTextChanged(it) },
        modifier = modifier,
        placeholder = { Text(placeholder)},
        label = { Text(label)},
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )

}


@Composable
fun PasswordOutlinedTextField(
    text: String,
    placeholder: String,
    label: String,
    onTextChanged: (String) -> Unit,
    keyboardType: KeyboardType,
    isPassword: Boolean = false,
    modifier: Modifier = Modifier
        .padding(16.dp),
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    var icon = if (passwordVisibility)
        painterResource(id = R.drawable.ic_visibility_icon)
    else
        painterResource(id = R.drawable.ic_off_visibility_icon)
        
    OutlinedTextField(
        value = text,
        onValueChange = {  onTextChanged(it) },
        modifier = modifier,
        placeholder = { Text(placeholder)},
        label = { Text(label)},
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility Icon")
            }
        },
        visualTransformation = if(passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}

@Composable
fun TaskText(
    text: String,
    placeholder: String,
    label: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier
        .padding(16.dp),
) {
    TextField(
        value = text,
        onValueChange = {  onTextChanged(it) },
        modifier = modifier,
        placeholder = { Text(placeholder)},
        label = { Text(label)},
    )

}

@Composable
fun SubTaskText(
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier
        .padding(16.dp),
) {
    TextField(
        value = text,
        onValueChange = {  onTextChanged(it) },
        modifier = modifier
    )


}

