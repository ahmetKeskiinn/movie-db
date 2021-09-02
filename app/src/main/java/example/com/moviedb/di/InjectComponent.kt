package example.com.moviedb.di

import dagger.Component
import example.com.moviedb.MainActivity
import example.com.moviedb.ui.home.HomeFactory
import example.com.moviedb.ui.home.HomeFragment
import example.com.moviedb.ui.home.HomeViewModel
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, SharedPrefModule::class, RetrofitModule::class, RoomModule::class])
interface InjectComponent {
    fun inject(activity: MainActivity)
    fun inject(homeViewModel: HomeViewModel)
    fun inject(homeFragment: HomeFragment)
    fun inject(homeFactory: HomeFactory)
}