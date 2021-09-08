package example.com.moviedb.features.fav.db

import androidx.lifecycle.LiveData
import androidx.room.*
import example.com.moviedb.features.fav.model.FavModel

@Dao
interface FavDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMovie(model: FavModel)

    @Delete
    fun deleteMovie(model: FavModel?)

    @Query("SELECT * FROM fav_table")
    fun getAllList() : LiveData<List<FavModel>>

    @Query("SELECT * FROM fav_table where movieId=:id")
    fun checkById(id: String): LiveData<List<FavModel>>
}