package example.com.moviedb

import android.os.Build
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import example.com.moviedb.features.detail.DetailFragment
import example.com.moviedb.features.fav.FavFragment
import example.com.moviedb.features.home.HomeFragment
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class FragmentLifeCycleTest {
    private lateinit var homeFragment: HomeFragment
    private lateinit var detailFragment: DetailFragment
    private lateinit var favFragment: FavFragment

    @Before
    fun setUp() {
        homeFragment = HomeFragment()
        detailFragment = DetailFragment()
        favFragment = FavFragment()
    }

    @Test
    @Throws(Exception::class)
    fun shouldNotBeNull() {
        assertNotNull(homeFragment)
        assertNotNull(detailFragment)
        assertNotNull(favFragment)
    }

    @Test
    fun startFragment() {
        fragmentStart(homeFragment)
        fragmentStart(favFragment)
        fragmentStart(detailFragment)
    }
    fun fragmentStart(fragment: Fragment) {
        val activity: FragmentActivity = Robolectric.buildActivity(FragmentActivity::class.java)
            .create()
            .start()
            .resume()
            .get()
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment, null)
        fragmentTransaction.commit()
        Thread.sleep(1000)
    }

    @Test
    fun pauseFragment() {
        fragmentStart(homeFragment)
        homeFragment.onPause()
        fragmentStart(favFragment)
        favFragment.onPause()
        fragmentStart(detailFragment)
        detailFragment.onPause()
    }

    @Test
    fun stopFragment() {
        fragmentStart(homeFragment)
        homeFragment.onStop()
        fragmentStart(favFragment)
        favFragment.onStop()
        fragmentStart(detailFragment)
        detailFragment.onStop()
    }

    @Test
    fun destroyFragment() {
        fragmentStart(homeFragment)
        homeFragment.onDestroy()
        fragmentStart(favFragment)
        favFragment.onDestroy()
        fragmentStart(detailFragment)
        detailFragment.onDestroy()
    }

    @Test
    fun resumeFragment() {
        fragmentStart(homeFragment)
        homeFragment.onDestroy()
        fragmentStart(favFragment)
        favFragment.onDestroy()
        fragmentStart(detailFragment)
        detailFragment.onDestroy()
    }
}
