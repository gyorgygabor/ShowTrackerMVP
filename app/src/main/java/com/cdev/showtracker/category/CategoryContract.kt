package com.cdev.showtracker.category

import com.cdev.showtracker.BasePresenter
import com.cdev.showtracker.BaseView
import com.cdev.showtracker.model.Category

/**
 * Created by cdev on 05.02.2017.
 */

class CategoryContract {
    interface Presenter : BasePresenter<View> {
        fun loadCategories()
    }

    interface View : BaseView {
        fun displayCategories(listOfCategories: List<Category>)
        fun displayEmptyState()
    }
}
