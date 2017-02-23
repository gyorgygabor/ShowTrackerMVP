package com.cdev.showtracker.category

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import com.cdev.showtracker.BaseApplication
import com.cdev.showtracker.R
import com.cdev.showtracker.model.Category
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

class CategoryActivity : AppCompatActivity(), CategoryContract.View {

    @Inject
    lateinit var presenter: CategoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        setSupportActionBar(toolbar)

        DaggerCategoryComponent.builder()
                .tvShowRepositoryComponent(BaseApplication.tvShowRepositoryComponent)
                .categoryPresenterModule(CategoryPresenterModule()).build()
                .inject(this)

        presenter.attachView(this)
        presenter.loadCategories()
    }

    override fun displayCategories(listOfCategories: List<Category>) {

        for (category in listOfCategories) {
            val categoryViewGroup: CategoryViewGroup = CategoryViewGroup(this)
            categoryViewGroup.setData(category)
            container.addView(categoryViewGroup)
        }

    }

    override fun displayEmptyState() {

    }

    override fun showProgressBar() {
        progressBar.visibility = VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
