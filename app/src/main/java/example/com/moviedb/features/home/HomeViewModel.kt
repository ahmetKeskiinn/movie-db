package example.com.moviedb.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import example.com.moviedb.features.home.model.MovieInfo
import example.com.moviedb.utils.APIKEY
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val popularMovieList: PopularMovieListSource) : ViewModel()  {
    private var _popularList = MutableLiveData<List<MovieInfo>>()
    fun getPopularMovies(page: Int): LiveData<List<MovieInfo>> {
        viewModelScope.launch {
            _popularList.value = popularMovieList.getMovieList(APIKEY,"en-US",1)
                    }
        return _popularList as LiveData<List<MovieInfo>>
    }
}