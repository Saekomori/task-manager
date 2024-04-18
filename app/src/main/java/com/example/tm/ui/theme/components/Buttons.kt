package com.example.tm.ui.theme.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonAuth(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(text = text,
            modifier = Modifier
                .padding(16.dp)
                .width(200.dp),
            textAlign = TextAlign.Center,
            )
    }
}

@Composable
fun ButtonFab(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,

    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@Composable
fun ButtonTask(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(2.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(text = text,
            modifier = Modifier
                .padding(16.dp)
                .width(50.dp),
            textAlign = TextAlign.Center,
        )
    }
}
