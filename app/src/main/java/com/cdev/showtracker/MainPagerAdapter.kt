package com.cdev.showtracker

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.cdev.showtracker.category.CategoryFragment


class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private companion object {
        val NUM_OF_PAGES: Int = 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return CategoryFragment.newInstance()
            1 -> return CategoryFragment.newInstance()
            2 -> return CategoryFragment.newInstance()
            else -> return CategoryFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return NUM_OF_PAGES
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "Discover"
            1 -> return "Favorites"
            2 -> return "My shows"
            else -> return ""
        }
    }
}