package example.com.moviedb.features.home

import androidx.lifecycle.LiveData
import androidx.paging.*
import example.com.moviedb.BuildConfig
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.utils.GetService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularMovieListSource @Inject constructor(private val api: GetService, private val homePagingSource: HomePagingSource) {
    suspend fun getMovieList(
        page: Int
    ): List<ResultInfo>? = withContext(Dispatchers.IO) {
        return@withContext api.getPopularMovieList(BuildConfig.API_KEY,page).results

    }
    fun getSearchList(movieName: String):LiveData<PagingData<ResultInfo>>{
        homePagingSource.key = movieName

        return Pager(
                config = PagingConfig(
                        pageSize = 5,
                        maxSize = 20,
                        enablePlaceholders = false
                ),
                pagingSourceFactory = {homePagingSource }
        ).liveData
    }
    fun getPopularMovieList() : LiveData<PagingData<ResultInfo>> {
        homePagingSource.key = ""
        return Pager(
                config = PagingConfig(
                        pageSize = 5,
                        maxSize = 20,
                        enablePlaceholders = false
                ),
                pagingSourceFactory = {homePagingSource }
        ).liveData
    }
}