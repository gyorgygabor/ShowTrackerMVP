package com.cdev.showtracker.details

import com.cdev.showtracker.data.TvShowRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by abrah on 3/12/2017.
 */
class DetailsPresenter @Inject constructor(repository: TvShowRepository) : DetailsContract.Presenter {

    private var view: DetailsContract.View? = null
    private var repository: TvShowRepository = repository

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
                            tvShow -> view?.showDetails(tvShow)
                        },
                        {
                            error -> view?.showError(error.message)
                        },
                        {
                            //todo do nothing
                        })

    }
}