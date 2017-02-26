package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.network.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class TvShowRemoteDataSource @Inject constructor(apiService: ApiService) : TvShowDataSource {
    // TODO Create a base call that will inject this key into every call
    var apiService: ApiService

    init {
        this.apiService = apiService
    }

    override fun getCategories(): Observable<Category> {
        return apiService.getCategories()
    }
}