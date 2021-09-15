package example.com.moviedb.features.fav

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import example.com.moviedb.features.fav.db.FavDatabase
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.utils.ViewModelKey
import javax.inject.Singleton

@Module
class FavModule {

    @Singleton
    @Provides
    fun providesFavRepository(db: FavDatabase): FavRepository {
        return FavRepository(db)
    }
    @Singleton
    @Provides
    fun providesFavDAO(favDatabase: FavDatabase) = favDatabase.getFavDao()
}
@Module
abstract class FavViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FavViewModel::class)
    internal abstract fun bindFavViewModel(viewModel: FavViewModel): ViewModel
}
