package example.com.moviedb.di

import android.content.SharedPreferences
import android.util.Log
import javax.inject.Inject

class Shared @Inject constructor() {
    fun save(shared: SharedPreferences) {
        Log.d("TAG", "save in shared Pref")
        shared.edit().putString("asd","asd")
    }
}