package com.loc.composesideeffects.side_effect

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

@Composable
fun SystemBarsColorChanger(
    statusBarColor: Color?,
    navigationBarColor: Color?
) {
    val window = (LocalContext.current as Activity).window

    SideEffect {
        statusBarColor?.let {
            window.statusBarColor = it.toArgb()
        }

        navigationBarColor?.let {
            window.navigationBarColor = it.toArgb()
        }
    }
}