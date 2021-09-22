package example.com.moviedb.features.detail

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import example.com.moviedb.features.detail.model.Detail
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.utils.changeFollowingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val movieDetailSource: MovieDetailSource,
    private val repo: FavRepository
) : ViewModel() {
    val data = MutableLiveData<Detail>()
    fun getMovieDetail(id: Int): LiveData<Detail> {
        viewModelScope.launch {
            data.postValue(movieDetailSource.getDetailForMovie(id))
        }
        return data
    }
    fun insertMovie(model: ResultInfo) {
        repo.insertMovie(model)
    }
    fun deleteMovie(model: ResultInfo) {
        repo.deleteMovie(model)
    }
    fun checkDB(model: Detail, imageView: ImageView) {

        CoroutineScope(Dispatchers.IO).launch {
            val size = model.id?.let { repo.checkById(it) }
            if (size != null) {
                if (size> 0) {
                    imageviewChange(true, imageView)
                } else {
                    imageviewChange(false, imageView)
                }
            }
        }
    }
    private fun imageviewChange(isFav: Boolean?, imageView: ImageView) {
        imageView.changeFollowingResource(isFav, imageView)
    }
    fun insertDeleteDB(model: Detail, imageView: ImageView) {
        var flag = 0
        CoroutineScope(Dispatchers.IO).launch {
            val size = model.id?.let { repo.checkById(it) }
            if (size == 0 && flag == 0) {
                flag = 1
                val model1 = ResultInfo(model.id, model.overview, model.title, model.posterPath, true)
                insertMovie(model1)
                imageviewChange(model1.isFav, imageView)
            } else {
                flag = 1
                val model1 = ResultInfo(model.id, model.overview, model.title)
                deleteMovie(model1)
                imageviewChange(model1.isFav, imageView)
            }
        }
    }
}
