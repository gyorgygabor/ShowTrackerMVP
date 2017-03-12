package com.cdev.showtracker.model

import com.google.gson.annotations.SerializedName

data class Category(var name: String, @SerializedName("results") val tvShows: List<TvShow>)

