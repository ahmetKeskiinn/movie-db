package example.com.moviedb.features.fav.db

import androidx.lifecycle.LiveData
import example.com.moviedb.features.fav.model.FavModel
import example.com.moviedb.features.fav.FavRepository

import javax.inject.Inject


class FavDataSource @Inject constructor(val favDao: FavDao) : FavRepository {

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