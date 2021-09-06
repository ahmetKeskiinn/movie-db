package example.com.moviedb.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import example.com.moviedb.features.home.model.MovieInfo
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val popularMovieList: PopularMovieListSource) : ViewModel()  {
    private var _popularList = MutableLiveData<List<ResultInfo>>()
    fun getPopularMovies(page: Int): LiveData<List<ResultInfo>> {
        viewModelScope.launch {
            _popularList.value = popularMovieList.getMovieList("en-US",1)
                    }
        return _popularList
    }
}