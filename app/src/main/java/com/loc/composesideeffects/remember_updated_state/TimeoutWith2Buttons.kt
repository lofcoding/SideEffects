package com.loc.composesideeffects.remember_updated_state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TimeoutWith2Buttons() {
    Column {
        var clickedButtonColor by remember {
            mutableStateOf("Unknown")
        }
        Button(
            onClick = { clickedButtonColor = "Red" },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Red Button")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { clickedButtonColor = "black" },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(text = "Black Button")
        }
        Timeout(buttonColor = clickedButtonColor)
    }
}
