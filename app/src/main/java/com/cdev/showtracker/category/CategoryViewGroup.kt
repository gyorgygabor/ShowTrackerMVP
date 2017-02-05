package com.cdev.showtracker.category

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.cdev.showtracker.R
import com.cdev.showtracker.model.Category
import kotlinx.android.synthetic.main.layout_category.view.*


/**
 * Created by cdev on 05.02.2017.
 */
class CategoryViewGroup(context: Context?) : LinearLayout(context) {

    private val categoryAdapter: CategoryAdapter = CategoryAdapter()

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_category, this)
        recyclerView.adapter = categoryAdapter
        recyclerView.layoutManager = LinearLayoutManager(context, HORIZONTAL, false)
    }

    fun setData(category: Category) {
        tvCategoryName.text = category.name
        categoryAdapter.addData(category.tvShows)
    }
}