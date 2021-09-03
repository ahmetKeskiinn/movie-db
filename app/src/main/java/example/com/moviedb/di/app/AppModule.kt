package example.com.moviedb.di.app

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(var app: Application) {
    var mApplication: Application
    @Provides
    @Singleton
    fun providesApplication(): Application {
        return mApplication
    }
    init {
        this.mApplication = app
    }
}