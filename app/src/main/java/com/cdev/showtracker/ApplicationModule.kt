package com.cdev.showtracker

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(applicationContext: Context) {
    var context: Context

    init {
        this.context = applicationContext
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return context
    }
}