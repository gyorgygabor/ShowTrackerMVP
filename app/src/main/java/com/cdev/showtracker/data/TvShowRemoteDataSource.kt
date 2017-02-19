package com.cdev.showtracker.data

import retrofit2.Retrofit
import javax.inject.Inject

class TvShowRemoteDataSource @Inject constructor(retrofit: Retrofit) : TvShowDataSource {
    var retrofit: Retrofit

    init {
        this.retrofit = retrofit
    }

    override fun getCategories(callback: TvShowDataSource.LoadCategoriesCallback) {

    }
}