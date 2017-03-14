package com.cdev.showtracker.model

import com.google.gson.annotations.SerializedName

/**
 * Created by abrah on 3/14/2017.
 */


data class TvShowVideo(@SerializedName("results") val result: List<ResultDetails>)

data class ResultDetails(@SerializedName("key") val key: String,
                         @SerializedName("site") val site: String,
                         @SerializedName("type") val type: String)