package com.cdev.showtracker.injection

import com.cdev.showtracker.category.CategoryActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by cdev on 05.02.2017.
 */
@Singleton
@Component(modules = arrayOf(PresenterModule::class))
interface PresenterComponent {
    fun inject(categoryActivity: CategoryActivity)
}