package com.example.lab4.ui.log

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Logcycle (private val lifecycle: Lifecycle, tag: String): LifecycleObserver {
init {
    lifecycle.addObserver(this)
}
    val LogTag="Logcycle:$tag"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        Log.d(LogTag, "ON CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        Log.d(LogTag, "ON RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {
        Log.d(LogTag, "ON PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        Log.d(LogTag, "ON DESTROYE")
    }

}

