package example.com.moviedb.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.fav.model.FavModel
import example.com.moviedb.features.home.model.MovieInfo
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val popularMovieList: PopularMovieListSource, private val repo:FavRepository) : ViewModel()  {
    private var _popularList = MutableLiveData<List<ResultInfo>>()
    private val _searchMovie = MutableLiveData<List<ResultInfo>>()
    fun getPopularMovies(page: Int): LiveData<List<ResultInfo>> {
        viewModelScope.launch {
            _popularList.value = popularMovieList.getMovieList(page)
                    }
        return _popularList
    }
    fun insertMovie(model:FavModel){
        repo.insertMovie(model)
    }
    fun deleteMovie(model:FavModel){
        repo.deleteMovie(model)
    }
    fun searchByMovieName(movieName: String) :LiveData<List<ResultInfo>>{
        viewModelScope.launch {
            _searchMovie.value = popularMovieList.getSearchList(movieName)
        }
        return _searchMovie
    }
    fun getAllList(): LiveData<List<FavModel>>{
        return repo.getAllList()
    }
    fun checkById(id: String): LiveData<List<FavModel>>{
        return repo.checkById(id)
    }
}