package com.example.theaudiodb

import android.app.Application
import com.example.theaudiodb.di.*
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
                    lovedRepositoryModule,
                    lovedViewModelModule
                )
            )
        }
    }
}