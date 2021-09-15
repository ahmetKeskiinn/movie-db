package example.com.moviedb.utils

import example.com.moviedb.features.home.model.ResultInfo

interface GetPopularDB {
    fun getData(x :List<ResultInfo>)
}