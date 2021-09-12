package example.com.moviedb.features.fav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.fav.model.FavModel
import javax.inject.Inject

class FavViewModel @Inject constructor(private var repo: FavRepository) : ViewModel() {

    fun getAllList(): LiveData<List<FavModel>>{
        return repo.getAllList()
    }
    fun deleteMovie(model:FavModel) {
        repo.deleteMovie(model)
    }
}