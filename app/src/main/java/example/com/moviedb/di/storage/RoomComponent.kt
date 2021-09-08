package example.com.moviedb.di.storage


import dagger.Component
import example.com.moviedb.features.fav.FavFragment
import example.com.moviedb.features.home.HomeFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomDatabaseModule::class, FavModule::class])
interface RoomComponent {
    fun inject(favFragment: FavFragment)
}