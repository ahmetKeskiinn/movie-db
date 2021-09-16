package example.com.moviedb.utils

import example.com.moviedb.features.home.model.ResultInfo

interface ClickListener {
    fun itemClick(data: ResultInfo)
}
