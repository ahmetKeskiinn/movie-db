package example.com.moviedb.utils

import example.com.moviedb.ui.detail.Detail
import example.com.moviedb.ui.home.model.Example
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GetService {
    @Headers(
            "Accept: application/json",
            "Content-Type: application/json")
    @GET("/movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: String,
                       @Query("api_key") apiKey:String,
                       @Query("language") language:String): retrofit2.Call<List<Detail?>>?

    @Headers(
            "Accept: application/json",
            "Content-Type: application/json"
    )
    @GET("/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String,
                         @Query("language") language: String,
                         @Query("page") page:Int): retrofit2.Call<List<Example?>>?

}