package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.model.TvShow
import io.reactivex.Observable

class TvShowLocalDataSource : TvShowDataSource {
    override fun getTvShowDetails(id: Int): Observable<TvShow> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCategories(categoryNames: List<String>): Observable<Category> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}