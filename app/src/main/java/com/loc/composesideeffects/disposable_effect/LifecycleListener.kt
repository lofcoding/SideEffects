package com.loc.composesideeffects.disposable_effect

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun LifecycleListener(
    onCreate:(() -> Unit)? = null,
    onStart:(() -> Unit)? = null,
    onResume:(() -> Unit)? = null,
    onPause:(() -> Unit)? = null,
    onStop:(() -> Unit)? = null,
    onDestroy:(() -> Unit)? = null,
    onAny:(() -> Unit)? = null,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(
        key1 = lifecycleOwner,
        effect = {
            val lifecycleObserver = LifecycleEventObserver { _, event ->
                when(event) {
                    Lifecycle.Event.ON_CREATE -> onCreate?.invoke()
                    Lifecycle.Event.ON_START -> onStart?.invoke()
                    Lifecycle.Event.ON_RESUME -> onResume?.invoke()
                    Lifecycle.Event.ON_PAUSE -> onPause?.invoke()
                    Lifecycle.Event.ON_STOP -> onStop?.invoke()
                    Lifecycle.Event.ON_DESTROY -> onDestroy?.invoke()
                    Lifecycle.Event.ON_ANY -> onAny?.invoke()
                }
            }
            lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
            onDispose {
                Log.d("test","Remove observer")
                lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
            }
        }
    )
}