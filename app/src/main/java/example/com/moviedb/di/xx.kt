package example.com.moviedb.di

import dagger.Component
import example.com.moviedb.ui.fav.FavViewModel
import example.com.moviedb.ui.home.HomeViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(RetrofitModule::class)])
interface xx {
    /**
     * Injects required dependencies into the specified CardListViewModel.
     * @param cardListViewModel CardListViewModel in which to inject the dependencies
     */
    fun inject(cardListViewModel: HomeViewModel)
    /**
     * Injects required dependencies into the specified CardViewModel.
     * @param cardViewModel CardViewModel in which to inject the dependencies
     */
    fun inject(cardViewModel: FavViewModel)

    @Component.Builder
    interface Builder {
        fun build(): xx

        fun networkModule(networkModule: RetrofitModule): Builder
    }
}