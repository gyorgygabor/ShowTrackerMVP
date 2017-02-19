package com.cdev.showtracker.category

import com.cdev.showtracker.data.TvShowRepository
import com.cdev.showtracker.model.Category
import com.cdev.showtracker.model.TvShow
import javax.inject.Inject

class CategoryPresenter @Inject constructor(repository: TvShowRepository) : CategoryContract.Presenter {
    private var view: CategoryContract.View? = null
    private var repository: TvShowRepository

    init {
        this.repository = repository
    }


    override fun attachView(view: CategoryContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadCategories() {
        val tvShows1: List<TvShow> = listOf(TvShow("Friends", 2))
        val tvShows2: List<TvShow> = listOf(TvShow("How I met your mother", 2))
        val tvShows3: List<TvShow> = listOf(TvShow("Walking dead", 2))

        val category1 = Category("Popular", tvShows1)
        val category2 = Category("Highly rated", tvShows2)
        val category3 = Category("Trending", tvShows3)

        view?.displayCategories(listOf(category1, category2, category3))
    }
}
