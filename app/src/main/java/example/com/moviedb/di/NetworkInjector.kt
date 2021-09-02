package example.com.moviedb.di

import dagger.Component
import example.com.moviedb.ui.fav.FavViewModel
import example.com.moviedb.ui.home.HomeFactory
import example.com.moviedb.ui.home.HomeViewModel
import example.com.moviedb.utils.BaseViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(RetrofitModule::class)])
interface NetworkInjector {
    fun inject(homeFactory: HomeFactory)
    fun inject(baseViewModel: BaseViewModel)
    fun inject(homeViewModel: HomeViewModel)
    fun inject(favViewModel: FavViewModel)

}