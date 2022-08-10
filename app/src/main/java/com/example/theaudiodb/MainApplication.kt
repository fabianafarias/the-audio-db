package com.example.theaudiodb

import android.app.Application
import com.example.theaudiodb.di.lovedApiModule
import com.example.theaudiodb.di.lovedDIModule
import com.example.theaudiodb.di.lovedRepositoryModule
import com.example.theaudiodb.di.lovedServiceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    lovedDIModule,
                    lovedApiModule,
                    lovedServiceModule,
                    lovedRepositoryModule
                )
            )
        }
    }
}