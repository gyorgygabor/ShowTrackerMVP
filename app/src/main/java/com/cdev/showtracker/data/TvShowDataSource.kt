package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category

interface TvShowDataSource {

    interface LoadCategoriesCallback {
        fun onCategoryLoaded(category: Category)
        fun onDataNotAvailable()
    }

    fun getCategories(callback: LoadCategoriesCallback)
}