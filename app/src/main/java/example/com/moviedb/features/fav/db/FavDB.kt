package example.com.moviedb.features.fav.db

import androidx.room.Database
import androidx.room.RoomDatabase
import example.com.moviedb.features.fav.model.FavModel


@Database(entities = [FavModel::class], version = FavDB.VERSION)
abstract class FavDB : RoomDatabase() {
    abstract val favDao: FavDao

    companion object {
        const val VERSION = 1
    }
}