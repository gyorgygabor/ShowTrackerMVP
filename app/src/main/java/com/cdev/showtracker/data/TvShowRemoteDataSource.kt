package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TvShowRemoteDataSource @Inject constructor(apiService: ApiService) : TvShowDataSource {
    // TODO Create a base call that will inject this key into every call
    var apiService: ApiService

    init {
        this.apiService = apiService
    }

    override fun getCategories(callback: TvShowDataSource.LoadCategoriesCallback) {
        val call: Call<Category> = apiService.getCategories()
        call.enqueue(object : Callback<Category> {
            override fun onResponse(call: Call<Category>?, response: Response<Category>?) {
                when (response?.isSuccessful) {
                // TODO Refactor Category to have an empty ctr (check if data class can have multiple constructors)
                    true -> callback.onCategoryLoaded(response?.body() ?: Category("Empty", emptyList()))
                    false -> callback.onDataNotAvailable()
                }
            }

            override fun onFailure(call: Call<Category>?, t: Throwable?) {
                callback.onDataNotAvailable()
            }
        })
    }
}