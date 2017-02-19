package com.cdev.showtracker.data

import android.util.Log

class TvShowLocalDataSource : TvShowDataSource {
    override fun getCategories(callback: TvShowDataSource.LoadCategoriesCallback) {
        Log.d("DATASOURCE", "getCategories() local")
    }
}