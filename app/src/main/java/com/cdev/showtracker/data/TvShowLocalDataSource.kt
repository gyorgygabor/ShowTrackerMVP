package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import io.reactivex.Observable

class TvShowLocalDataSource : TvShowDataSource {
    override fun getCategories(categoryNames: List<String>): Observable<Category> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}