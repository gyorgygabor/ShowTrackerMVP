package com.cdev.showtracker.category

import com.cdev.showtracker.data.TvShowRepository
import com.cdev.showtracker.model.Category
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.*
import javax.inject.Inject

class CategoryPresenter @Inject constructor(repository: TvShowRepository) : CategoryContract.Presenter {
    private var view: CategoryContract.View? = null
    private var repository: TvShowRepository = repository


    override fun attachView(view: CategoryContract.View) {
        this.view = view
    }

    override fun loadCategories() {
        view?.showProgressBar()
        val categoryList: ArrayList<Category> = ArrayList()

        repository.getCategories(listOf("Popular", "Top rated", "On the Air", "Latest"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { category -> categoryList.add(category)},
                        {
                            e ->
                            view?.displayError(e.message)
                            view?.hideProgressBar()
                        },
                        {
                            view?.displayCategories(categoryList)
                            view?.hideProgressBar()
                        }
                )
    }

    override fun detachView() {
        view = null
    }
}
