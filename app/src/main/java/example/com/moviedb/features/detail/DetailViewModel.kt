package example.com.moviedb.features.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import example.com.moviedb.features.detail.model.Detail
import example.com.moviedb.features.home.PopularMovieListSource
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val movieDetailSource: MovieDetailSource) : ViewModel() {
    var _detail: Detail = Detail()
    fun getMovieDetail(id: Int) :Detail{
        viewModelScope.launch {
            runBlocking {
                _detail = movieDetailSource.getDetailForMovie(id)
            }


            }
        return _detail
        }
    }
