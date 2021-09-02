package example.com.moviedb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import example.com.moviedb.ui.home.model.Example
import example.com.moviedb.utils.BaseViewModel
import retrofit2.Retrofit
import javax.inject.Inject

class HomeViewModel: BaseViewModel() {
    @Inject
    lateinit var retrofit: Retrofit

    private var quote: LiveData<List<Example>>? = null
    fun getProjectData(page: Int): LiveData<List<Example>> {
      //  quote = homeRepository.getPopularMovies(1)
        return quote as LiveData<List<Example>>
    }
}