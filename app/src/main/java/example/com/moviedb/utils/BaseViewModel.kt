package example.com.moviedb.utils

import androidx.lifecycle.ViewModel
import example.com.moviedb.di.DaggerNetworkInjector
import example.com.moviedb.di.NetworkInjector
import example.com.moviedb.di.RetrofitModule
import example.com.moviedb.ui.fav.FavViewModel
import example.com.moviedb.ui.home.HomeRepository
import example.com.moviedb.ui.home.HomeViewModel
import javax.inject.Inject

abstract class BaseViewModel: ViewModel() {

    private val injector: NetworkInjector = DaggerNetworkInjector
            .builder()
            .retrofitModule(RetrofitModule())
            .build()

    init {
        inject()
        injector.inject(this)

    }

    private fun inject() {
        when (this) {
            is HomeViewModel -> injector.inject(this)
             is FavViewModel -> injector.inject(this)
        }
    }

}