package com.cdev.showtracker.category

import com.cdev.showtracker.category.CategoryContract

/**
 * Created by cdev on 05.02.2017.
 */
class CategoryPresenterImp : CategoryContract.CategoryPresenter {

    private var view: CategoryContract.CategoryView? = null

    override fun attachView(view: CategoryContract.CategoryView) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadCategories() {

    }

}
