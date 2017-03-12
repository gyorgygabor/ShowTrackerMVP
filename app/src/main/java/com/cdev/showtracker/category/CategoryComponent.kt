package com.cdev.showtracker.category

import com.cdev.showtracker.data.TvShowRepositoryComponent
import com.cdev.showtracker.util.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(TvShowRepositoryComponent::class), modules = arrayOf(CategoryPresenterModule::class))
interface CategoryComponent {
    fun inject(categoryActivity: CategoryFragment)
}