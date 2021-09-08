package example.com.moviedb.di.storage


import dagger.Module
import dagger.Provides
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.fav.db.FavDatabase
import javax.inject.Singleton

@Module
class FavModule {

    @Singleton
    @Provides
    fun providesFavRepository(db: FavDatabase): FavRepository {
        return FavRepository(db)
    }

}