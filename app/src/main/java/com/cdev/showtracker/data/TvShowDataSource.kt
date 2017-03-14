package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.model.TvShowVideo
import io.reactivex.Observable

interface TvShowDataSource {

    fun getCategories(categoryNames: List<String>): Observable<Category>

    fun getTvShowDetails(id: Int): Observable<TvShow>

    fun getTvShowVideos(id: Int): Observable<TvShowVideo>
}