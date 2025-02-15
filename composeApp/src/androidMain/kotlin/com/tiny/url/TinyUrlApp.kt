package com.tiny.url

import android.app.Application
import com.tiny.url.di.initKoin
import org.koin.android.ext.koin.androidContext

class TinyUrlApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@TinyUrlApp)
        }
    }
}