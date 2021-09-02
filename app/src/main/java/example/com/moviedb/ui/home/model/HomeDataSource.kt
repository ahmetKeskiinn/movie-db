package example.com.moviedb.ui.home.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import example.com.moviedb.ui.home.HomeRepository
import example.com.moviedb.utils.ApiUtils
import example.com.moviedb.utils.GetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class HomeDataSource @Inject constructor(val retrofit: Retrofit) : HomeRepository {


    override fun getPopularMovies(page: Int): LiveData<List<Example>> {
        val apiResponse = MutableLiveData<List<Example>>()
        val apiService = retrofit.create(GetService::class.java)
        val call: Call<List<Example?>>? = apiService.getPopularMovies(ApiUtils().APIKEY, ApiUtils().LANGUAGE, page)
        call?.enqueue(object : Callback<List<Example?>> {
            override fun onFailure(call: Call<List<Example?>>, t: Throwable) {
            }

            override fun onResponse(
                    call: Call<List<Example?>>,
                    response: Response<List<Example?>>
            ) {
                if (response.isSuccessful) {
                    apiResponse.postValue(response.body()!! as List<Example>?)
                }
            }

        })
        return apiResponse
    }

}