package example.com.moviedb.features.fav.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import example.com.moviedb.features.home.model.ResultInfo

@Dao
interface FavDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMovie(model: ResultInfo)

    @Delete
    suspend fun deleteMovie(model: ResultInfo?)

    @Query("SELECT COUNT(movieNumb) FROM fav WHERE movieNumb =:id")
    fun checkById(id: Int): Int

    @Query("SELECT * FROM fav where isFav=1")
    fun getAllList(): LiveData<List<ResultInfo>>
}
