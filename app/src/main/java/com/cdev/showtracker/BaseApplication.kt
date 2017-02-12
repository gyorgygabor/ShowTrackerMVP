package com.cdev.showtracker

import android.app.Application
import com.cdev.showtracker.injection.DaggerPresenterComponent
import com.cdev.showtracker.injection.PresenterComponent
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class BaseApplication : Application() {

    companion object {
        lateinit var presenterComponent: PresenterComponent
    }

    override fun onCreate() {
        super.onCreate()

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
        presenterComponent = DaggerPresenterComponent.builder().build()
    }
}