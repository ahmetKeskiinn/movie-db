package example.com.moviedb.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.fav.FavViewModel
import javax.inject.Inject

class FavMovieViewModelFactory @Inject constructor(private var repo: FavRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavViewModel(repo) as T
    }
}