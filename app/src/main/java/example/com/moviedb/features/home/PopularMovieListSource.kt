package example.com.moviedb.features.home

import example.com.moviedb.features.home.model.Example
import example.com.moviedb.utils.GetService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularMovieListSource @Inject constructor(private val api: GetService) {
    suspend fun getMovieList(
        key: String, language: String, page: Int
    ): Example = withContext(Dispatchers.IO) {
        api.getPopularMovieList(key)
    }
}