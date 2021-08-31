package example.com.moviedb.di

import android.util.Log
import retrofit2.Retrofit
import javax.inject.Inject

class Retrof @Inject constructor() {
    fun hook(retrofit: Retrofit) {
        Log.d("TAG", "Hook accomplish with virtual")
    }
}