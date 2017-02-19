package com.cdev.showtracker.category

import com.cdev.showtracker.data.TvShowRepositoryComponent
import dagger.Component

@Component(dependencies = arrayOf(TvShowRepositoryComponent::class), modules = arrayOf(CategoryPresenterModule::class))
interface CategoryComponent {
    fun inject(categoryActivity: CategoryActivity)
}