package com.cdev.showtracker.network

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.model.TvShowVideo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    // TODO make a base call with injected API key
    @GET("tv/popular?api_key=0a416fc6c49f4a04db6e3bd398ef8579&language=en-US&page=1")
    fun getCategoryPopular(): Observable<Category>

    @GET("tv/top_rated?api_key=0a416fc6c49f4a04db6e3bd398ef8579&language=en-US&page=1")
    fun getCategoryTopRated(): Observable<Category>

    @GET("tv/on_the_air?api_key=0a416fc6c49f4a04db6e3bd398ef8579&language=en-US&page=1")
    fun getCategoryOnTheAir(): Observable<Category>

    @GET("tv/airing_today?api_key=0a416fc6c49f4a04db6e3bd398ef8579&language=en-US")
    fun getCategoryAiringToday(): Observable<Category>

    @GET("tv/{tv_id}?api_key=0a416fc6c49f4a04db6e3bd398ef8579&language=en-US")
    fun getTvShowDetails(@Path("tv_id") id: Int): Observable<TvShow>

    @GET("tv/{tv_id}/videos?api_key=0a416fc6c49f4a04db6e3bd398ef8579&language=en-US")
    fun getTvShowVideo(@Path("tv_id") id: Int): Observable<TvShowVideo>
}