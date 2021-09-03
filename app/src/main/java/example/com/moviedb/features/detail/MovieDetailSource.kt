package example.com.moviedb.features.detail

import example.com.moviedb.features.detail.model.Detail
import example.com.moviedb.utils.GetService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MovieDetailSource @Inject constructor(private val api: GetService) {
    suspend fun getDetailForMovie(id: Int): Detail = withContext(Dispatchers.IO) {
        val infoOfMovie = api.getSelectedMovie(id)
        infoOfMovie
    }
}