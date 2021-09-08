package example.com.moviedb.features.fav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.fav.model.FavModel

class FavViewModel(private var repo: FavRepository) : ViewModel() {

    fun insertMovie(model: FavModel){
        repo.insertMovie(model)
    }
    fun getAllList(): LiveData<List<FavModel>>{
        return repo.getAllList()
    }
    fun deleteMovie(model:FavModel) {
        repo.deleteMovie(model)
    }
}