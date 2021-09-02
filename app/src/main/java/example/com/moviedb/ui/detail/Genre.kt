package example.com.moviedb.ui.detail

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Genre {
    @SerializedName("id")
    @Expose
    var ıd: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null
}