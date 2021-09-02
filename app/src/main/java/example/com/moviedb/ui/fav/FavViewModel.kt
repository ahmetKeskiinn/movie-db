package example.com.moviedb.ui.fav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import example.com.moviedb.utils.BaseViewModel

class FavViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is fav Fragment"
    }
    val text: LiveData<String> = _text
}