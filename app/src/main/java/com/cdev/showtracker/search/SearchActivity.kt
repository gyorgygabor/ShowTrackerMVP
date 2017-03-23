package com.cdev.showtracker.search

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.cdev.showtracker.R

import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbar)
        searchView.showSearch(false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val item = menu?.findItem(R.id.action_search)
        searchView.setMenuItem(item)

        return true
    }
}
