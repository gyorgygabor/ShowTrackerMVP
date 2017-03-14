package com.cdev.showtracker.details

import com.cdev.showtracker.data.TvShowRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by abraham on 3/12/2017.
 */
class DetailsPresenter @Inject constructor(private var repository: TvShowRepository) : DetailsContract.Presenter {

    private var view: DetailsContract.View? = null

    override fun attachView(view: DetailsContract.View) {
        this.view = view

    }

    override fun detachView() {
        view = null
    }

    override fun loadDetails(id: Int) {

        repository.getTvShowDetails(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            tvShow ->
                            view?.showDetails(tvShow)
                        },
                        {
                            error ->
                            view?.showError(error.message)
                        },
                        {
                            //todo do nothing
                        })

    }

    override fun loadTvShowVideo(id: Int) {
        repository.getTvShowVideos(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            (result) ->
                            view?.showVideo(result.filter { it.type.equals("Trailer", ignoreCase = true) }.first())
                        },
                        {
                            error ->
                            view?.showError(error.message)
                            //TODO: handle errors
                        })
    }
}