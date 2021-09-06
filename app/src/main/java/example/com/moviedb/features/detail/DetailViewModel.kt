package example.com.moviedb.features.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import example.com.moviedb.features.detail.model.Detail
import example.com.moviedb.features.home.PopularMovieListSource
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val movieDetailSource: MovieDetailSource) : ViewModel() {
    private lateinit var _detail : Detail
    fun getPopularMovies(page: Int): LiveData<List<ResultInfo>> {
        viewModelScope.launch {
            _detail = movieDetailSource.getDetailForMovie(1)
        }
        return _detail as LiveData<List<ResultInfo>>
    }
}