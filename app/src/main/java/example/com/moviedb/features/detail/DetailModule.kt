package example.com.moviedb.features.detail

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import example.com.moviedb.utils.GetService
import example.com.moviedb.utils.ViewModelKey
import javax.inject.Singleton

@Module
class DetailModule {

    @Provides
    @Singleton
    internal fun provideDetailMovies(detailApi: GetService): MovieDetailSource = MovieDetailSource(detailApi)
}
@Module
abstract class DetailViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    internal abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel
}
