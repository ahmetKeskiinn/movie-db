package example.com.moviedb.features.home.model

import com.google.gson.annotations.SerializedName

data class Results(
        @SerializedName("results") val networkMovie: List<MovieInfo>,
        val page: Int,
        val total_results: Int,
        val total_pages: Int
)
