package example.com.moviedb.features.home

import android.util.Log
import example.com.moviedb.features.home.model.MovieInfo
import example.com.moviedb.utils.GetService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularMovieListSource @Inject constructor(private val api: GetService) {
    suspend fun getMovieList(
        key: String, language: String, page: Int
    ): List<MovieInfo> = withContext(Dispatchers.IO) {
        Log.d("TAG", "getMovieList: " + api.getPopularMovieList(key).networkMovie.size)
        return@withContext api.getPopularMovieList(key).networkMovie

    }
}