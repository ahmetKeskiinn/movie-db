package example.com.moviedb.ui.fav

import androidx.lifecycle.LiveData
import example.com.moviedb.ui.fav.model.FavModel


interface FavRepository {
    fun findById(id: Int): LiveData<FavModel?>?
    fun findAll(): LiveData<List<FavModel?>?>?
    fun insert(model: FavModel?): Long
    fun delete(model: FavModel?): Int
}