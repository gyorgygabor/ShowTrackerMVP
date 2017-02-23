package com.cdev.showtracker.model

import com.google.gson.annotations.SerializedName

/**
 * Created by cdev on 05.02.2017.
 */

data class TvShow(@SerializedName("name") val name: String,
                  @SerializedName("backdrop_path") val imagePath: String)