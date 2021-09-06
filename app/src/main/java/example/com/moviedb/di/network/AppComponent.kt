package example.com.moviedb.di.network

import dagger.Component
import example.com.moviedb.di.viewmodel.ViewModelModule
import example.com.moviedb.features.detail.DetailFragment
import example.com.moviedb.features.home.HomeFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent{
    fun inject(homeFragment: HomeFragment)
    fun inject(detailFragment: DetailFragment)

}