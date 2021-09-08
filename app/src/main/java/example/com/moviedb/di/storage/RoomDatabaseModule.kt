package example.com.moviedb.di.storage

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import example.com.moviedb.features.fav.db.FavDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
class RoomDatabaseModule(val application: Application) {

    //private lateinit var db: FavDatabase

    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.d("RoomDatabaseModule", "onCreate")
            CoroutineScope(Dispatchers.IO).launch {
                addSampleBooksToDatabase()
            }
        }
    }

    private fun addSampleBooksToDatabase() {
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): FavDatabase {
       val db = Room.databaseBuilder(application, FavDatabase::class.java, "fav_db")
            .fallbackToDestructiveMigration()
            .addCallback(databaseCallback)
            .build()
        return db
    }

    @Singleton
    @Provides
    fun providesBookDAO(libraryDatabase: FavDatabase) = libraryDatabase.getFavDao()
}