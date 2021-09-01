package example.com.moviedb

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.RoomDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView
import example.com.moviedb.di.Modules
import example.com.moviedb.ui.fav.FavRepository
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var retrofit:Retrofit
    @Inject lateinit var favRepository: FavRepository
    @Inject lateinit var sharedPref:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_home
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        (application as MyApp).injectComponent?.inject(this@MainActivity)

    }
}