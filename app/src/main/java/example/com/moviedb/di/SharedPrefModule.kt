package example.com.moviedb.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPrefModule {
    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application?): SharedPreferences {
        var sharedPreferences: SharedPreferences
        sharedPreferences =  application?.applicationContext!!.getSharedPreferences("DaggerExample",
            Context.MODE_PRIVATE)
        return sharedPreferences
    }
}