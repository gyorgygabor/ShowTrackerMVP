package com.cdev.showtracker

import com.cdev.showtracker.BaseView

/**
 * Created by cdev on 05.02.2017.
 */
interface BasePresenter<T : BaseView> {
    fun attachView(view: T)
    fun detachView()
}