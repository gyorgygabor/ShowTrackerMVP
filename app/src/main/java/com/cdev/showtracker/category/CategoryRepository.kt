package com.cdev.showtracker.category

import com.cdev.showtracker.model.Category

interface CategoryRepository {
    fun getCategories(): List<Category>
}
