package example.com.moviedb.ui.fav.db

import androidx.lifecycle.LiveData
import androidx.room.*
import example.com.moviedb.ui.fav.model.FavModel


@Dao
interface FavDao {
    @Query("SELECT * FROM fav_table WHERE name=:id")
    fun findById(id: Int): LiveData<FavModel?>?

    @Query("SELECT * FROM fav_table")
    fun findAll(): LiveData<List<FavModel?>?>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(model: FavModel?): Long

    @Delete
    fun delete(model: FavModel?): Int
}