package example.com.moviedb.features.home

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap
import example.com.moviedb.features.detail.DetailViewModel
import example.com.moviedb.utils.GetService
import example.com.moviedb.utils.ViewModelKey

@Module
class HomeModule {
    @Provides
    @Reusable
    internal fun providePopularMovies(api: GetService, homePagingSource: HomePagingSource): PopularMovieListSource = PopularMovieListSource(api,homePagingSource)
    @Provides
    @Reusable
    internal fun providePagingMovies(api: GetService): HomePagingSource = HomePagingSource( api )
}
@Module
abstract class HomeViewModelModule{
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindDetailViewModel(viewModel: HomeViewModel): ViewModel
}