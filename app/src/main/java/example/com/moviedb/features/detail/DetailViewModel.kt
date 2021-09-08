package example.com.moviedb.features.detail

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import example.com.moviedb.features.detail.model.Detail
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.fav.model.FavModel
import example.com.moviedb.features.home.PopularMovieListSource
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val movieDetailSource: MovieDetailSource, private val repo:FavRepository) : ViewModel() {
    val data = MutableLiveData<Detail>()
    fun getMovieDetail(id: Int) :LiveData<Detail>{
        viewModelScope.launch {
            data.postValue(movieDetailSource.getDetailForMovie(id))

            }
        return data
        }
    fun insertMovie(model:FavModel){
        repo.insertMovie(model)
    }
    fun deleteMovie(model:FavModel){
        repo.deleteMovie(model)
    }
    fun checkDB(id:String): LiveData<List<FavModel>>{
        return repo.checkById(id)
    }
}
