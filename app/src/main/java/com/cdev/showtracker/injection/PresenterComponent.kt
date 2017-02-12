package com.cdev.showtracker.injection

import com.cdev.showtracker.category.CategoryActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(PresenterModule::class))
interface PresenterComponent {
    fun inject(categoryActivity: CategoryActivity)
}