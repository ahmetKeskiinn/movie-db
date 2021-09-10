package example.com.moviedb.features.home.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class MovieInfo(val results: List<ResultInfo>)