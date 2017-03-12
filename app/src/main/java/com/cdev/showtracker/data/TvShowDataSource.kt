package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import io.reactivex.Observable

interface TvShowDataSource {

    fun getCategories(categoryNames: List<String>): Observable<Category>
}