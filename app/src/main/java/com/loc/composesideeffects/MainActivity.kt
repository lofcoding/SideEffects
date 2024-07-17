package com.loc.composesideeffects

import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.loc.composesideeffects.derived_state_of.NumbersList
import com.loc.composesideeffects.disposable_effect.LifecycleListener
import com.loc.composesideeffects.remember_coroutine_scope.NamesList
import com.loc.composesideeffects.remember_updated_state.TimeoutWith2Buttons
import com.loc.composesideeffects.snapshot_flow.LoggingTextInput
import com.loc.composesideeffects.ui.theme.ComposeSideEffectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSideEffectsTheme {
                
            }
        }
    }
}
