package com.cdev.showtracker.network

import com.cdev.showtracker.model.Category
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    // TODO make a base call with injected API key
    @GET("tv/popular?api_key=0a416fc6c49f4a04db6e3bd398ef8579&language=en-US&page=1")
    fun getCategories(): Observable<Category>
}