package example.com.moviedb.features.fav.db

import androidx.lifecycle.LiveData
import androidx.room.*
import example.com.moviedb.features.home.model.ResultInfo

@Dao
interface FavDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMovie(model: ResultInfo)

    @Delete
    fun deleteMovie(model: ResultInfo?)

    @Query("SELECT * FROM fav where movieNumb=:id")
    fun checkById(id: String): LiveData<List<ResultInfo>>

    @Query("SELECT * FROM fav where isFav=1")
    fun getAllList(): LiveData<List<ResultInfo>>
}