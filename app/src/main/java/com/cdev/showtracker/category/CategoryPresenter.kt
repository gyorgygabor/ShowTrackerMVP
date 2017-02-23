package com.cdev.showtracker.category

import com.cdev.showtracker.data.TvShowDataSource
import com.cdev.showtracker.data.TvShowRepository
import com.cdev.showtracker.model.Category
import java.util.*
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
        repository.getCategories(object : TvShowDataSource.LoadCategoriesCallback {
            override fun onCategoryLoaded(category: Category) {

                // TODO merge multiple categories with RxJava
                val categoryList = ArrayList<Category>()
                categoryList.add(category)
                view?.displayCategories(categoryList)
            }

            override fun onDataNotAvailable() {
                view?.displayEmptyState()
            }
        })
    }
}
