package example.com.moviedb

import android.app.Application
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import example.com.moviedb.di.AppComponent
import example.com.moviedb.di.DaggerAppComponent
import example.com.moviedb.di.NetworkModule
import example.com.moviedb.di.RoomDatabaseModule
import javax.inject.Inject

class MyApp : Application() {

    companion object{
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().networkModule(NetworkModule(this)).roomDatabaseModule(
            RoomDatabaseModule(this)
        ).build()
    }

}

