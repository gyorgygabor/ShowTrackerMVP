package com.cdev.showtracker.category

import com.cdev.showtracker.BasePresenter
import com.cdev.showtracker.BaseView
import com.cdev.showtracker.model.Category


class CategoryContract {
    interface Presenter : BasePresenter<View> {
        fun loadCategories()
    }

    interface View : BaseView {
        fun showProgressBar()
        fun hideProgressBar()
        fun displayCategories(listOfCategories: List<Category>)
        fun displayError(error: String?)
        fun displayEmptyState()
    }
}
