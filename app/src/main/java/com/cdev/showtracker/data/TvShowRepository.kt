package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.model.TvShow
import io.reactivex.Observable
import javax.inject.Inject

class TvShowRepository @Inject constructor(remoteDataSource: TvShowRemoteDataSource) : TvShowDataSource {


    private val remoteDataSource: TvShowRemoteDataSource = remoteDataSource

    override fun getCategories(categoryNames: List<String>): Observable<Category> {
        return remoteDataSource.getCategories(categoryNames)
    }

    override fun getTvShowDetails(id: Int): Observable<TvShow> {
       return remoteDataSource.getTvShowDetails(id)
    }

}