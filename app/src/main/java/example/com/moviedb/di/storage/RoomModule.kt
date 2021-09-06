package example.com.moviedb.di.storage

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/*@Module
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


    init {
        db = Room.databaseBuilder(mApplication!!.applicationContext, FavDB::class.java, "demo-db").build()
    }
}*/