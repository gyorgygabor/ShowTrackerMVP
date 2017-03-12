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

    override fun detachView() {
        view = null
    }

    override fun loadCategories() {
        view?.showProgressBar()
        val categoryList: ArrayList<Category> = ArrayList()

        repository.getCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { category -> categoryList.add(category) },
                        {
                            e ->
                            view?.displayError(e.message ?: "Something went wrong")
                            view?.hideProgressBar()
                        },
                        {
                            view?.displayCategories(categoryList)
                            view?.hideProgressBar()
                        }
                )
    }
}
