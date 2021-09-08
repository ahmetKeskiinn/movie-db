package example.com.moviedb.features.fav.db

import androidx.room.Database
import androidx.room.RoomDatabase
import example.com.moviedb.features.fav.model.FavModel

@Database(entities = [FavModel::class], version = 1)
abstract class FavDatabase : RoomDatabase() {
    abstract fun getFavDao(): FavDAO
}