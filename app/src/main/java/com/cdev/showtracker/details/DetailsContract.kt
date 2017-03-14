package com.cdev.showtracker.details

import com.cdev.showtracker.BasePresenter
import com.cdev.showtracker.BaseView
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.model.TvShowVideo

/**
 * Created by abrah on 3/12/2017.
 */
interface DetailsContract {

    interface Presenter : BasePresenter<View> {
        fun loadDetails(id: Int)
        fun loadTvShowVideo(id: Int)
    }

    interface View : BaseView {
        fun showDetails(tvShow: TvShow)
        fun showError(error: String?)
        fun showVideo(tvShowVideo: TvShowVideo)
    }

}