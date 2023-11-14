package com.shubhans.googlysocialproject

import android.app.Application
import com.google.gson.internal.GsonBuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class SocialApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}