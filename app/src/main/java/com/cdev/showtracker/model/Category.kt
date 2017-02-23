package com.cdev.showtracker.model

import com.google.gson.annotations.SerializedName

data class Category(val name: String, @SerializedName("results") val tvShows: List<TvShow>)

