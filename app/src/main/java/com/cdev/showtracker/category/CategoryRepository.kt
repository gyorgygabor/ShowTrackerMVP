package com.cdev.showtracker.category

import com.cdev.showtracker.model.Category

/**
 * Created by cdev on 05.02.2017.
 */

interface CategoryRepository {
    fun getCategories(): List<Category>
}
