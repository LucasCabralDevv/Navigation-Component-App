package com.lucascabral.navigationapplication

import android.app.Application
import com.lucascabral.navigationapplication.ui.di.registrationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(registrationModule)
        }
    }
}