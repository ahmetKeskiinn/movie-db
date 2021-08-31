package example.com.moviedb.di

import android.content.SharedPreferences
import retrofit2.Retrofit
import javax.inject.Inject

class Modules @Inject constructor(shared: SharedPreferences, retro: Retrofit) {
    var shared: SharedPreferences
    var retro: Retrofit
    fun save() {
        var sharedP : Shared = Shared()
        sharedP.save(shared)
        var retrofx : Retrof = Retrof()
        retrofx.hook(retro)
    }
    fun hook(){

    }

    init {
        this.shared = shared
        this.retro = retro
    }
}