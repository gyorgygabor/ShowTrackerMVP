package com.cdev.showtracker.injection

import com.cdev.showtracker.category.CategoryPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideCategoryPresenter(): CategoryPresenter {
        return CategoryPresenter()
    }
}