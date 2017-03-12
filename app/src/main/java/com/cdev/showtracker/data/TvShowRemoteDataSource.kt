package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.network.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class TvShowRemoteDataSource @Inject constructor(apiService: ApiService) : TvShowDataSource {
    // TODO Create a base call that will inject this key into every call
    var apiService: ApiService = apiService

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
                apiService.getCategoryLatest().map { category ->
                    category.name = categoryNames[3]
                    category // return
                })
    }
}