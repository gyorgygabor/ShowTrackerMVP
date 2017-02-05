package com.cdev.showtracker.category

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cdev.showtracker.R
import com.cdev.showtracker.model.Category

class CategoryActivity : AppCompatActivity(), CategoryContract.CategoryView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
    }

    override fun displayCategories(listOfCategories: List<Category>) {

    }

    override fun displayEmptyState() {

    }
}
