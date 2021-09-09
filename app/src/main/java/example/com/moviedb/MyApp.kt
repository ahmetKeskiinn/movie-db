package example.com.moviedb

import android.app.Application
import example.com.moviedb.di.network.AppComponent
import example.com.moviedb.di.network.DaggerAppComponent
import example.com.moviedb.di.network.NetworkModule
import example.com.moviedb.di.storage.RoomDatabaseModule

class MyApp : Application() {

    companion object{
        lateinit var appComponent: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        appComponent =DaggerAppComponent.builder().networkModule(NetworkModule(this)).roomDatabaseModule(RoomDatabaseModule(this)).build()
    }


}