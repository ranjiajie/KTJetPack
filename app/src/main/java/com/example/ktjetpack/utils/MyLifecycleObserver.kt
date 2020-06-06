package com.example.ktjetpack.utils

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MyLifecycleObserver : DefaultLifecycleObserver{
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("MyLifecycleObserver", "onCreate")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("MyLifecycleObserver", "onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("MyLifecycleObserver", "onPause")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("MyLifecycleObserver", "onStart")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("MyLifecycleObserver", "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("MyLifecycleObserver", "onDestroy")
    }
}