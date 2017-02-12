package com.cdev.showtracker

interface BasePresenter<in T : BaseView> {
    fun attachView(view: T)
    fun detachView()
}