package example.com.moviedb

import android.app.Application
import example.com.moviedb.di.*

class MyApp : Application() {
    var injectComponent: InjectComponent? = null
    override fun onCreate() {
        super.onCreate()
        injectComponent = DaggerInjectComponent.builder()
            .appModule(AppModule(this))
            .retrofitModule(RetrofitModule())
            .sharedPrefModule(SharedPrefModule())
            .roomModule(RoomModule(AppModule(this).mApplication))
            .build();
    }

}