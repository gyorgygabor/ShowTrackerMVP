package com.cdev.showtracker.network

import com.cdev.showtracker.model.Category
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    // TODO make a base call with injected API key
    @GET("tv/popular?api_key=...&language=en-US&page=1")
    fun getCategories(): Call<Category>
}