package example.com.moviedb.di.network

import dagger.Component
import example.com.moviedb.di.storage.FavModule
import example.com.moviedb.di.storage.RoomDatabaseModule
import example.com.moviedb.di.viewmodel.ViewModelModule
import example.com.moviedb.features.detail.DetailFragment
import example.com.moviedb.features.fav.FavFragment
import example.com.moviedb.features.home.HomeFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class, RoomDatabaseModule::class, FavModule::class])
interface AppComponent{
    fun inject(homeFragment: HomeFragment)
    fun inject(detailFragment: DetailFragment)
    fun inject(favFragment: FavFragment)
}