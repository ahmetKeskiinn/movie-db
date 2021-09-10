package example.com.moviedb.features.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.utils.GetService
import retrofit2.HttpException
import java.io.IOException


private const val FIRST_PAGE_INDEX = 1

class HomePagingSource(
    private val apiService: GetService,
    private val query: String?
) : PagingSource<Int, ResultInfo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultInfo> {
        return try {
            val position: Int = params.key ?: FIRST_PAGE_INDEX
            val response =
                if (query != null) apiService.searchMovies(
                    query,
                    position
                ) else apiService.getNowPlayingMovies(
                    position
                )
            val movies = response.results
            LoadResult.Page(
                data = movies,
                prevKey = if (position == FIRST_PAGE_INDEX) null else position - 1,
                nextKey = if (movies.isEmpty()) null else position + 1
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