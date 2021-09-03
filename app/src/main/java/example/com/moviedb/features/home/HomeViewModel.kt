package example.com.moviedb.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import example.com.moviedb.features.home.model.Example
import example.com.moviedb.utils.APIKEY
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val popularMovieList: PopularMovieListSource) : ViewModel()  {
    private var _popularList = MutableLiveData<List<Example>>()
    fun getPopularMovies(page: Int): LiveData<List<Example>> {
        viewModelScope.launch {
            popularMovieList.getMovieList(APIKEY,"en-US",1)
                    }
        return _popularList as LiveData<List<Example>>
    }
}