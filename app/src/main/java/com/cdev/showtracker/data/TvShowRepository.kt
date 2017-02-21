package com.cdev.showtracker.data

import javax.inject.Inject

class TvShowRepository @Inject constructor(remoteDataSource: TvShowRemoteDataSource) : TvShowDataSource {

    private val remoteDataSource: TvShowRemoteDataSource

    init {
        this.remoteDataSource = remoteDataSource
    }

    override fun getCategories(callback: TvShowDataSource.LoadCategoriesCallback) {
        remoteDataSource.getCategories(callback)
    }
}