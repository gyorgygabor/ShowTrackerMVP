package com.cdev.showtracker

import android.app.Application
import com.cdev.showtracker.data.DaggerTvShowRepositoryComponent
import com.cdev.showtracker.data.TvShowRepositoryComponent
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class BaseApplication : Application() {

    companion object {
        lateinit var tvShowRepositoryComponent: TvShowRepositoryComponent
    }

    override fun onCreate() {
        super.onCreate()

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )

        tvShowRepositoryComponent = DaggerTvShowRepositoryComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    fun getTvShowRepositoryComponent(): TvShowRepositoryComponent {
        return tvShowRepositoryComponent
    }
}