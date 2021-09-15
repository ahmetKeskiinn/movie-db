package example.com.moviedb.features.fav.db

import androidx.room.Database
import androidx.room.RoomDatabase
import example.com.moviedb.features.fav.model.FavModel
import example.com.moviedb.features.home.model.ResultInfo

@Database(
    entities = [
        FavModel::class,
        ResultInfo::class
    ],
    version = 1
)
abstract class FavDatabase : RoomDatabase() {
    abstract fun getFavDao(): FavDAO
}
