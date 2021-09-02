package example.com.moviedb.ui.home

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import example.com.moviedb.ui.home.model.Example
import example.com.moviedb.utils.ApiUtils
import example.com.moviedb.utils.GetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

interface HomeRepository{
    fun getPopularMovies(page:Int) :  LiveData<List<Example>>
}