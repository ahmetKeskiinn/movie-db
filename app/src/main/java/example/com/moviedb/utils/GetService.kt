package example.com.moviedb.utils

import androidx.lifecycle.LiveData
import example.com.moviedb.BuildConfig
import example.com.moviedb.features.detail.model.Detail
import example.com.moviedb.features.home.model.MovieInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetService {
    @GET("/3/movie/popular")
    suspend fun getPopularMovieList(
        @Query("api_key") key: String = BuildConfig.API_KEY,@Query("page") page:Int
    ): MovieInfo

    @GET("movie/{id}?api_key=${BuildConfig.API_KEY}&language=en-US")
    suspend fun getSelectedMovie(@Path("id") id: Int): Detail

    @GET("/3/search/movie")
    suspend fun getSearchedList(
            @Query("api_key") key: String = BuildConfig.API_KEY,@Query("query") movieName: String
    ): MovieInfo

}