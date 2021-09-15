package example.com.moviedb.di

import android.app.Application
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
    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(Dispatchers.IO).launch {
                addSampleBooksToDatabase()
            }
        }
    }

    private fun addSampleBooksToDatabase() {
    } // burayı fragmente al oncreate view'da çağır

    @Singleton
    @Provides
    fun providesRoomDatabase(): FavDatabase {
        val db = Room.databaseBuilder(application, FavDatabase::class.java, "fav_db")
            .fallbackToDestructiveMigration()
            .addCallback(databaseCallback)
            .build()
        return db
    }
}
