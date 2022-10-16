package com.example.statetest

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
@Composable
fun ButtonType(
    text: String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary),
        shape = MaterialTheme.shapes.medium

    ) {
        Text(
            text = text,
            fontSize = 30.sp
        )
    }
}
