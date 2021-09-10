package example.com.moviedb.features.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import example.com.moviedb.BuildConfig
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.utils.GetService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


private const val FIRST_PAGE_INDEX = 1

class HomePagingSource @Inject constructor(val apiService: GetService) : PagingSource<Int, ResultInfo>() {
    var key:String = ""
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultInfo> {
        return try {
            val position: Int = params.key ?: FIRST_PAGE_INDEX
            val response =if(key.isEmpty()){
                apiService.getPopularMovieList(
                        BuildConfig.API_KEY,
                        position
                )
            }
            else{
                apiService.getSearchedList(
                        BuildConfig.API_KEY,
                        key
                )
            }
            val popularMovies = response.results
            LoadResult.Page(
                data = popularMovies,
                prevKey = if (position == FIRST_PAGE_INDEX) null else position - 1,
                nextKey = if (popularMovies.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResultInfo>): Int? {
        TODO("Not yet implemented")
    }

}