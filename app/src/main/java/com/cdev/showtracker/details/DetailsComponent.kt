package com.cdev.showtracker.details

import com.cdev.showtracker.data.TvShowRepositoryComponent
import com.cdev.showtracker.util.ActivityScope
import dagger.Component

/**
 * Created by abrah on 3/12/2017.
 */

@ActivityScope
@Component(dependencies = arrayOf(TvShowRepositoryComponent::class), modules = arrayOf(DetailsPresenterModule::class))
interface DetailsComponent {
    fun inject(detailsActivity: DetailsActivity)
}
