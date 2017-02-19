package com.cdev.showtracker.category

import com.cdev.showtracker.data.TvShowRepository
import dagger.Module
import dagger.Provides

@Module
class CategoryPresenterModule {

    @Provides
    fun provideCategoryPresenter(repository: TvShowRepository): CategoryPresenter {
        return CategoryPresenter(repository)
    }
}