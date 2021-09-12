package example.com.moviedb.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import example.com.moviedb.features.detail.DetailViewModel
import example.com.moviedb.features.fav.FavViewModel
import example.com.moviedb.features.home.HomeViewModel
import example.com.moviedb.utils.ViewModelFactory
import example.com.moviedb.utils.ViewModelKey

@Module
abstract class FactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}