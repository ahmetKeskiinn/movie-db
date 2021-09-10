package example.com.moviedb.features.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import androidx.paging.cachedIn
import example.com.moviedb.BuildConfig
import example.com.moviedb.features.home.model.MovieInfo
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.utils.GetService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularMovieListSource @Inject constructor(private val api: GetService) {
    suspend fun getMovieList(
        page: Int
    ): List<ResultInfo>? = withContext(Dispatchers.IO) {
        return@withContext api.getPopularMovieList(BuildConfig.API_KEY,page).results

    }
    suspend fun getSearchList(movieName: String): List<ResultInfo>? = withContext(Dispatchers.IO) {
        return@withContext api.getSearchedList(BuildConfig.API_KEY, movieName).results
    }
    fun getPopularMovieList() = Pager(
        config = PagingConfig(
            pageSize = 5,
            maxSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { HomePagingSource(api, null) }
    ).liveData
}