package example.com.moviedb.features.home.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class MovieInfo {
    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("results")
    @Expose
    var resultInfos: List<ResultInfo>? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null

    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null
}