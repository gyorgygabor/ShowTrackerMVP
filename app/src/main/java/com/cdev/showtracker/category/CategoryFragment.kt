package com.cdev.showtracker.category

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.cdev.showtracker.BaseApplication
import com.cdev.showtracker.R
import com.cdev.showtracker.model.Category
import com.cdev.showtracker.util.snack
import kotlinx.android.synthetic.main.fragment_category.*
import javax.inject.Inject

class CategoryFragment : Fragment(), CategoryContract.View {

    @Inject
    lateinit var presenter: CategoryPresenter

    companion object {
        fun newInstance(): CategoryFragment {
            return CategoryFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerCategoryComponent.builder()
                .tvShowRepositoryComponent(BaseApplication.tvShowRepositoryComponent)
                .categoryPresenterModule(CategoryPresenterModule()).build()
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.loadCategories()
    }

    override fun displayCategories(listOfCategories: List<Category>) {
        for (category in listOfCategories) {
            val categoryViewGroup: CategoryViewGroup = CategoryViewGroup(container.context)
            categoryViewGroup.setData(category)
            container.addView(categoryViewGroup)
        }
    }

    override fun displayEmptyState() {

    }

    override fun displayError(error: String?) {
        rootView.snack(error ?: getString(R.string.error_something_went_wrong))
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
