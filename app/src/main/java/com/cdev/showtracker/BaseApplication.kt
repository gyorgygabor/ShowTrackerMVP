package com.cdev.showtracker

import android.app.Application
import com.cdev.showtracker.injection.DaggerPresenterComponent
import com.cdev.showtracker.injection.PresenterComponent

/**
 * Created by cdev on 05.02.2017.
 */
class BaseApplication : Application() {

    companion object {
        lateinit var presenterComponent: PresenterComponent
    }

    override fun onCreate() {
        super.onCreate()
        presenterComponent = DaggerPresenterComponent.builder().build()
    }
}