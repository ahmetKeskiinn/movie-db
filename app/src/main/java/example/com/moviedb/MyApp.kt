package example.com.moviedb

import android.app.Application
import example.com.moviedb.di.AppModule
import example.com.moviedb.di.DaggerInjectComponent
import example.com.moviedb.di.InjectComponent
import example.com.moviedb.di.InjectModule

class MyApp : Application() {
    var injectComponent: InjectComponent? = null
    override fun onCreate() {
        super.onCreate()
        injectComponent = DaggerInjectComponent.builder()
            .appModule(AppModule(this))
            .injectModule(InjectModule("https://api.github.com"))
            .build();
    }
    fun getAppComponent(): InjectComponent? {
        return injectComponent
    }

}