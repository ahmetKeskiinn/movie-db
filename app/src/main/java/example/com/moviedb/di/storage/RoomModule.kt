package example.com.moviedb.di.storage

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import example.com.moviedb.features.fav.db.FavDB
import example.com.moviedb.features.fav.db.FavDao
import example.com.moviedb.features.fav.db.FavDataSource
import example.com.moviedb.features.fav.FavRepository
import javax.inject.Singleton


@Module
class RoomModule(mApplication: Application) {
    private val db: FavDB
    @Singleton
    @Provides
    fun providesRoomDatabase(): FavDB {
        return db
    }

    @Singleton
    @Provides
    fun providesFavDao(db: FavDB): FavDao {
        return db.favDao
    }

    @Singleton
    @Provides
    fun favRepository(favDao: FavDao): FavRepository {
        return FavDataSource(favDao)
    }

    init {
        db = Room.databaseBuilder(mApplication!!.applicationContext, FavDB::class.java, "demo-db").build()
    }
}