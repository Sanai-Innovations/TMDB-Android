package com.sanai.tmdbclient

import android.app.Application
import com.sanai.tmdbclient.presentation.di.AppDI

class TMDBApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // initializing the application component if we want to inject any
        // value here too in this application file
        AppDI.getApplicationComponent(this).inject(this)
    }
}