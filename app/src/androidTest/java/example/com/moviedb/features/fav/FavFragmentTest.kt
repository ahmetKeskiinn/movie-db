package example.com.moviedb.features.fav

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import example.com.moviedb.R
import example.com.moviedb.utils.adapters.PopularListAdapter
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavFragmentTest : TestCase() {
    private lateinit var scenario: FragmentScenario<FavFragment>
    @Before
    public override fun setUp() {
        super.setUp()
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_AppCompat_DayNight_DarkActionBar)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testGridButton() {
        Espresso.onView(ViewMatchers.withId(R.id.gridButton)).perform(ViewActions.click())
        Thread.sleep(1000)
    }
    @Test
    fun testListButton() {
        Espresso.onView(ViewMatchers.withId(R.id.listButton)).perform(ViewActions.click())
        Thread.sleep(1000)
    }
    @Test
    fun recyclerViewScrollTest() {
        Thread.sleep(1500)
        Espresso.onView(ViewMatchers.withId(R.id.favRecycler))
            .perform(RecyclerViewActions.scrollToPosition<PopularListAdapter.MovieHolder>(1))
        Thread.sleep(1500)
    }
}
