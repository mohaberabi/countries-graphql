package com.mohaberabi.countriesgraphql

import android.app.Application
import com.mohaberabi.countriesgraphql.country.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CountryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
// some

            
            androidContext(this@CountryApplication)
            androidLogger()
            modules(
                appModule,
            )
        }
    }
}

