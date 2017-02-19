package com.cdev.showtracker.network

import com.cdev.showtracker.model.Category
import retrofit2.Call
import retrofit2.http.GET

interface RestApi {
    @GET("/categories")
    fun getCategories(): Call<List<Category>>
}