package example.com.moviedb.di

import dagger.Component
import example.com.moviedb.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, InjectModule::class])
interface InjectComponent {
    fun inject(activity: MainActivity?)
}