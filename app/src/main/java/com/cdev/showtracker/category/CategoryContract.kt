package com.cdev.showtracker.category

import com.cdev.showtracker.BasePresenter
import com.cdev.showtracker.BaseView
import com.cdev.showtracker.model.Category


interface CategoryContract {
    interface Presenter : BasePresenter<View> {
        fun loadCategories()
    }

    interface View : BaseView {
        fun showProgressBar()
        fun hideProgressBar()
        fun showCategories(listOfCategories: List<Category>)
        fun showError(error: String?)
        fun showEmptyState()
    }
}
