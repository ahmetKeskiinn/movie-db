package example.com.moviedb.features.fav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavViewModel @Inject constructor(private var repo: FavRepository) : ViewModel() {

    fun getAllList(): LiveData<List<ResultInfo>> {
        return repo.getAllList()
    }
    fun deleteMovie(model: ResultInfo) {
        CoroutineScope(Dispatchers.IO).launch {
            repo.deleteMovie(model)
        }
    }
    fun insertMovie(model: ResultInfo) {
        CoroutineScope(Dispatchers.IO).launch {
            repo.insertMovie(model)
        }
    }
}
