package com.cdev.showtracker.category

import com.cdev.showtracker.data.TvShowRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class CategoryPresenter @Inject constructor(repository: TvShowRepository) : CategoryContract.Presenter {
    private var view: CategoryContract.View? = null
    private var repository: TvShowRepository

    init {
        this.repository = repository
    }


    override fun attachView(view: CategoryContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadCategories() {
        // TODO merge multiple categories into a list, handle unsubscription
        view?.showProgressBar()
        repository.getCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    category ->
                    view?.displayCategories(arrayListOf(category))
                }
    }
}
