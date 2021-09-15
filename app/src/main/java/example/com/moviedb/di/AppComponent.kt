package example.com.moviedb.di

import dagger.Component
import example.com.moviedb.features.detail.DetailFragment
import example.com.moviedb.features.detail.DetailViewModelModule
import example.com.moviedb.features.fav.FavFragment
import example.com.moviedb.features.fav.FavModule
import example.com.moviedb.features.fav.FavViewModelModule
import example.com.moviedb.features.home.HomeFragment
import example.com.moviedb.features.home.HomeViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        FactoryModule::class,
        RoomDatabaseModule::class,
        FavModule::class,
        DetailViewModelModule::class,
        HomeViewModelModule::class,
        FavViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(homeFragment: HomeFragment)
    fun inject(detailFragment: DetailFragment)
    fun inject(favFragment: FavFragment)
}
