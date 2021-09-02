package example.com.moviedb.ui.home

import androidx.lifecycle.LiveData
import dagger.Provides
import example.com.moviedb.ui.home.model.Example
import javax.inject.Singleton


interface HomeRepository{
    @Singleton
    fun getPopularMovies(page:Int) :  LiveData<List<Example>>
}