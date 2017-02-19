package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category

interface TvShowDataSource {

    interface LoadCategoriesCallback {
        fun onCategoriesLoaded(list: List<Category>)
        fun onDataNotAvailable()
    }

    fun getCategories(callback: LoadCategoriesCallback)
}