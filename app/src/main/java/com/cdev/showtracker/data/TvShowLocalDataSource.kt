package com.cdev.showtracker.data

import com.cdev.showtracker.model.Category
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.model.TvShowVideo
import io.reactivex.Observable
import io.reactivex.Single

class TvShowLocalDataSource : TvShowDataSource {
    override fun getTvShowVideos(id: Int): Single<TvShowVideo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTvShowDetails(id: Int): Single<TvShow> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCategories(categoryNames: List<String>): Observable<Category> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}