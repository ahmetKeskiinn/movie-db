package example.com.moviedb.features.home

import androidx.lifecycle.LiveData
import example.com.moviedb.features.home.model.MovieInfo
import javax.inject.Singleton


interface HomeRepository{
    @Singleton
    fun getPopularMovies(page:Int) :  LiveData<List<MovieInfo>>
}