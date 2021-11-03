package com.example.dookoff.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun CommonDialog(
    title: String,
    text: String,
    state: MutableState<Boolean>,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss.invoke() },
        title = {
                Column(Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween) {
                    Text(title)
                    Divider()
                    Text(text)
                }
        },
        dismissButton = {
               Button(onClick = {state.value = false}){
                   Text("Cancel")
               }
        },
        confirmButton = {
            Button(onClick = {state.value = false}){
                Text("Confirm")
            }
        }
    )
}