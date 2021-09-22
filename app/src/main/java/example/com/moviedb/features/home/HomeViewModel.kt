package example.com.moviedb.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val popularMovieList: PopularMovieListSource,
    private val repo: FavRepository
) : ViewModel() {
    fun insertMovie(model: ResultInfo) {
        CoroutineScope(Dispatchers.IO).launch {
            model.isFav = true
            repo.insertMovie(model)
        }
    }
    fun deleteMovie(model: ResultInfo) {
        CoroutineScope(Dispatchers.IO).launch {
            model.isFav = false
            repo.deleteMovie(model)
        }
    }
    fun searchByMovieName(movieName: String): LiveData<PagingData<ResultInfo>> {
        return popularMovieList.getSearchList(movieName)
    }
    fun getDbList(): LiveData<List<ResultInfo>> {
        return repo.getAllList()
    }

    fun checkById(model: ResultInfo) {
        var a = 0
        CoroutineScope(Dispatchers.IO).launch {
            var size = model.movieNumb?.let { repo.checkById(it) }
            if (size == 0 && a == 0) {
                a = 1
                insertMovie(model)
            } else {
                a = 1
                deleteMovie(model)
            }
        }
    }
    fun getPopularMovieList(): LiveData<PagingData<ResultInfo>> {
        return popularMovieList.getPopularMovieList()
    }
}
