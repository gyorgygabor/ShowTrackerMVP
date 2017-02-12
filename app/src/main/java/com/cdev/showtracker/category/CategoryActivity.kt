package com.cdev.showtracker.category

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cdev.showtracker.BaseApplication
import com.cdev.showtracker.R
import com.cdev.showtracker.model.Category
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import javax.inject.Inject

class CategoryActivity : AppCompatActivity(), CategoryContract.View {

    @Inject
    lateinit var presenter: CategoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        BaseApplication.presenterComponent.inject(this)
        setSupportActionBar(toolbar)

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

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base))
    }
}
