package example.com.moviedb.features.home

import androidx.lifecycle.LiveData
import example.com.moviedb.features.home.model.Example
import javax.inject.Singleton


interface HomeRepository{
    @Singleton
    fun getPopularMovies(page:Int) :  LiveData<List<Example>>
}