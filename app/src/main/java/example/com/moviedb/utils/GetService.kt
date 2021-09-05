package example.com.moviedb.utils

import example.com.moviedb.features.detail.model.Detail
import example.com.moviedb.features.home.model.MovieInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetService {
    @GET("/3/movie/popular")
    suspend fun getPopularMovieList(
        @Query("api_key") key: String = APIKEY
    ): MovieInfo

    @GET("movie/{id}?api_key=$APIKEY&language=en-US")
    suspend fun getSelectedMovie(@Path("id") id: Int): Detail

}