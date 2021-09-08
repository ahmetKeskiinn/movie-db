package example.com.moviedb.features.fav.db

import androidx.lifecycle.LiveData
import example.com.moviedb.features.fav.model.FavModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavRepository(db: FavDatabase) {

    private var favDao: FavDAO = db.getFavDao()

    fun insertMovie(model: FavModel) {
        CoroutineScope(Dispatchers.IO).launch {
            favDao.addMovie(model)
        }
    }
    fun getAllList() : LiveData<List<FavModel>> {
         return favDao.getAllList()
    }

    fun deleteMovie(model: FavModel) {
        CoroutineScope(Dispatchers.IO).launch {
            favDao.deleteMovie(model)
        }
    }
    fun checkById(id:String): LiveData<List<FavModel>> {
        return favDao.checkById(id)
    }
}