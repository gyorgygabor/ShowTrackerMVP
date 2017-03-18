package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.model.TvShowVideo
import com.cdev.showtracker.network.ApiService
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class TvShowRemoteDataSource @Inject constructor(var apiService: ApiService) : TvShowDataSource {

    override fun getCategories(categoryNames: List<String>): Observable<Category> {
        return Observable.concat(
                apiService.getCategoryPopular().map { category ->
                    category.name = categoryNames[0]
                    category // return
                },
                apiService.getCategoryTopRated().map { category ->
                    category.name = categoryNames[1]
                    category // return
                },
                apiService.getCategoryOnTheAir().map { category ->
                    category.name = categoryNames[2]
                    category // return
                },
                apiService.getCategoryAiringToday().map { category ->
                    category.name = categoryNames[3]
                    category // return
                })
    }

    override fun getTvShowDetails(id: Int): Single<TvShow> {
        return apiService.getTvShowDetails(id)
    }

    override fun getTvShowVideos(id: Int): Single<TvShowVideo> {
        return apiService.getTvShowVideo(id)
    }
}