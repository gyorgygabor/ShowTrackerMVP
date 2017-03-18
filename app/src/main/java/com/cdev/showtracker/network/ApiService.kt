package com.cdev.showtracker.network

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.model.TvShowVideo
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    // TODO make a base call with injected API key
    @GET("tv/popular?language=en-US&page=1")
    fun getCategoryPopular(): Observable<Category>

    @GET("tv/top_rated?language=en-US&page=1")
    fun getCategoryTopRated(): Observable<Category>

    @GET("tv/on_the_air?language=en-US&page=1")
    fun getCategoryOnTheAir(): Observable<Category>

    @GET("tv/airing_today?language=en-US")
    fun getCategoryAiringToday(): Observable<Category>

    @GET("tv/{tv_id}?language=en-US")
    fun getTvShowDetails(@Path("tv_id") id: Int): Single<TvShow>

    @GET("tv/{tv_id}/videos?language=en-US")
    fun getTvShowVideo(@Path("tv_id") id: Int): Single<TvShowVideo>
}