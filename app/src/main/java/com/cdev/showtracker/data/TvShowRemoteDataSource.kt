package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.network.RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TvShowRemoteDataSource @Inject constructor(restApi: RestApi) : TvShowDataSource {
    var restApi: RestApi

    init {
        this.restApi = restApi
    }

    override fun getCategories(callback: TvShowDataSource.LoadCategoriesCallback) {
        var call: Call<List<Category>> = restApi.getCategories()
        call.enqueue(object : Callback<List<Category>> {
            override fun onFailure(call: Call<List<Category>>?, t: Throwable?) {
                throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<Category>>?, response: Response<List<Category>>?) {
                throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}