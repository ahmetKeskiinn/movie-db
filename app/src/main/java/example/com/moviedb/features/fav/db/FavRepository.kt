package example.com.moviedb.features.fav.db

import androidx.lifecycle.LiveData
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavRepository(db: FavDatabase) {

    private var favDao: FavDAO = db.getFavDao()

    fun insertMovie(model: ResultInfo) {
        CoroutineScope(Dispatchers.IO).launch {
            favDao.addMovie(model)
        }
    }
    fun getAllList(): LiveData<List<ResultInfo>> {
        return favDao.getAllList()
    }
    fun deleteMovie(model: ResultInfo) {
        CoroutineScope(Dispatchers.IO).launch {
            favDao.deleteMovie(model)
        }
    }
    fun checkById(id: Int): Int {

        return favDao.checkById(id)
    }
}
