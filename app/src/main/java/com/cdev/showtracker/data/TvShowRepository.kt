package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import io.reactivex.Observable
import javax.inject.Inject

class TvShowRepository @Inject constructor(remoteDataSource: TvShowRemoteDataSource) : TvShowDataSource {

    private val remoteDataSource: TvShowRemoteDataSource

    init {
        this.remoteDataSource = remoteDataSource
    }

    override fun getCategories(): Observable<Category> {
        return remoteDataSource.getCategories()
    }

}