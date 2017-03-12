package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import io.reactivex.Observable
import javax.inject.Inject

class TvShowRepository @Inject constructor(remoteDataSource: TvShowRemoteDataSource) : TvShowDataSource {

    private val remoteDataSource: TvShowRemoteDataSource = remoteDataSource

    override fun getCategories(categoryNames: List<String>): Observable<Category> {
        return remoteDataSource.getCategories(categoryNames)
    }

}