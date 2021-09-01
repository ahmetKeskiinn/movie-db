package example.com.moviedb.ui.fav.db

import androidx.lifecycle.LiveData
import example.com.moviedb.ui.fav.model.FavModel
import example.com.moviedb.ui.fav.FavRepository

import javax.inject.Inject


class FavDataSource @Inject constructor(favDao: FavDao) : FavRepository {
    private var favDao: FavDao

    init {
        this.favDao = favDao
    }

    override fun findById(id: Int): LiveData<FavModel?>? {
        return favDao.findById(id);
    }

    override fun findAll(): LiveData<List<FavModel?>?>? {
        return favDao.findAll();
    }

    override fun insert(model: FavModel?): Long {
        return favDao.insert(model);
    }

    override fun delete(model: FavModel?): Int {
        return favDao.delete(model);
    }
}