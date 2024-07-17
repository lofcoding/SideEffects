package com.loc.composesideeffects.snapshot_flow

import android.util.Log
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.filter

@Composable
fun LoggingTextInput() {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        value = text,
        onValueChange = { text = it }
    )

    val textFlow = snapshotFlow { text }
    LaunchedEffect(key1 = Unit) {
        textFlow
            .filter { it.length > 5 }
            .collect {
                Log.d("test", it)
            }
    }
}