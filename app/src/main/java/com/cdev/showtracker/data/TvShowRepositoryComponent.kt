package com.cdev.showtracker.data

import com.cdev.showtracker.ApplicationModule
import com.cdev.showtracker.injection.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, TvShowRepositoryModule::class, NetModule::class))
interface TvShowRepositoryComponent {
    fun getTvShowRepository(): TvShowRepository
}