package com.ashtoncoulson.kotlinmvvmtemplate

import android.app.Application
import com.ashtoncoulson.kotlinmvvmtemplate.di.apiModule
import com.ashtoncoulson.kotlinmvvmtemplate.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(apiModule + viewModelModule)
        }
    }
}