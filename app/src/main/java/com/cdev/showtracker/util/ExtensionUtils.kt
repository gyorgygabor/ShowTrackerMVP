package com.cdev.showtracker.util

import android.support.design.widget.Snackbar
import android.view.View
import android.widget.ImageView
import com.cdev.showtracker.network.ApiConfig
import com.squareup.picasso.Picasso

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}

fun ImageView.loadUrl(path: String){

    Picasso.with(this.context)
            .load(ApiConfig.DETAILS_IMG_BASE_URL + path)
            .into(this)
}

