package com.cdev.showtracker

import android.app.Application
import com.cdev.showtracker.data.DaggerTvShowRepositoryComponent
import com.cdev.showtracker.data.TvShowRepositoryComponent
import com.cdev.showtracker.injection.NetModule
import com.cdev.showtracker.network.ApiConfig
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class BaseApplication : Application() {

    companion object {
        // TODO make it private and use the getter
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
                .netModule(NetModule(ApiConfig.BASE_URL))
                .build()
    }

    fun getTvShowRepositoryComponent(): TvShowRepositoryComponent {
        return tvShowRepositoryComponent
    }
}