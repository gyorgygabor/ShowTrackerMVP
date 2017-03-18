package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.model.TvShowVideo
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val remoteDataSource: TvShowRemoteDataSource) : TvShowDataSource {

    override fun getCategories(categoryNames: List<String>): Observable<Category> {
        return remoteDataSource.getCategories(categoryNames)
    }

    override fun getTvShowDetails(id: Int): Single<TvShow> {
        return remoteDataSource.getTvShowDetails(id)
    }

    override fun getTvShowVideos(id: Int): Single<TvShowVideo> {
        return remoteDataSource.getTvShowVideos(id)
    }

}