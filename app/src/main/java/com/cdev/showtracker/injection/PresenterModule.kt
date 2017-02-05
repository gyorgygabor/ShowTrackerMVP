package com.cdev.showtracker.injection

import com.cdev.showtracker.category.CategoryPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by cdev on 05.02.2017.
 */
@Module
class PresenterModule {

    @Provides
    fun provideCategoryPresenter(): CategoryPresenter {
        return CategoryPresenter()
    }
}