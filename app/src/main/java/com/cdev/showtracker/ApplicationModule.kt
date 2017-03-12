package com.cdev.showtracker

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(applicationContext: Context) {
    var context: Context = applicationContext

    @Provides
    fun provideApplicationContext(): Context {
        return context
    }
}