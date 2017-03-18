package com.cdev.showtracker.category

import com.cdev.showtracker.data.TvShowRepository
import com.cdev.showtracker.model.Category
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import javax.inject.Inject

class CategoryPresenter @Inject constructor(private var repository: TvShowRepository) : CategoryContract.Presenter {

    private var view: CategoryContract.View? = null
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun attachView(view: CategoryContract.View) {
        this.view = view
    }

    override fun loadCategories() {
        view?.showProgressBar()
        val categoryList: ArrayList<Category> = ArrayList()

        compositeDisposable.add(repository.getCategories(listOf("Popular", "Top rated", "On the Air", "Airing today"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { category -> categoryList.add(category) },
                        {
                            e ->
                            view?.showError(e.message)
                            view?.hideProgressBar()
                        },
                        {
                            view?.showCategories(categoryList)
                            view?.hideProgressBar()
                        }
                ))
    }

    override fun detachView() {
        view = null
        compositeDisposable.clear()
    }
}
