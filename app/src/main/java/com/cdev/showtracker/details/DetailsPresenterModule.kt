package com.cdev.showtracker.details

import com.cdev.showtracker.category.CategoryPresenter
import com.cdev.showtracker.data.TvShowRepository
import dagger.Module
import dagger.Provides

/**
 * Created by abrah on 3/12/2017.
 */

@Module
class DetailsPresenterModule {

    @Provides
    fun provideDetailsPresenter(repository: TvShowRepository): DetailsPresenter {
        return DetailsPresenter(repository)
    }

}