package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.model.TvShowVideo
import io.reactivex.Observable
import io.reactivex.Single

interface TvShowDataSource {

    fun getCategories(categoryNames: List<String>): Observable<Category>

    fun getTvShowDetails(id: Int): Single<TvShow>

    fun getTvShowVideos(id: Int): Single<TvShowVideo>
}