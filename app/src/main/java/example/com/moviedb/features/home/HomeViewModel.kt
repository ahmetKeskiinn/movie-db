package example.com.moviedb.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.fav.model.FavModel
import example.com.moviedb.features.home.model.ResultInfo
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val popularMovieList: PopularMovieListSource, private val repo:FavRepository) : ViewModel()  {
    fun insertMovie(model:FavModel){
        repo.insertMovie(model)
    }
    fun deleteMovie(model:FavModel){
        repo.deleteMovie(model)
    }
    fun searchByMovieName(movieName: String) :LiveData<PagingData<ResultInfo>>{
        return popularMovieList.getSearchList(movieName)
    }
    fun getAllList(): LiveData<List<FavModel>>{
        return repo.getAllList()
    }
    fun checkById(id: String): LiveData<List<FavModel>>{
        return repo.checkById(id)
    }
    fun getPopularMovieList(): LiveData<PagingData<ResultInfo>> {
        return popularMovieList.getPopularMovieList()
    }

}