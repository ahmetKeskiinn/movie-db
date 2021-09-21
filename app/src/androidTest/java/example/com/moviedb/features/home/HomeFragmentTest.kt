package example.com.moviedb.features.home

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import example.com.moviedb.R
import example.com.moviedb.utils.adapters.PopularListAdapter
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest : TestCase() {

    private lateinit var scenario: FragmentScenario<HomeFragment>

    @Before
    public override fun setUp() {
        scenario =
            launchFragmentInContainer(themeResId = R.style.Theme_AppCompat_DayNight_DarkActionBar)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testClickSearchButton() {
        onView(withId(R.id.searchButton)).perform(click())
        val movieName = "Hababam Sınıfı"
        onView(withId(R.id.searchMovie)).perform(replaceText(movieName))
        Thread.sleep(1000)
    }

    @Test
    fun testClickGridButton() {
        onView(withId(R.id.gridButton)).perform(click())
        Thread.sleep(1000)
    }

    @Test
    fun testClickListButton() {
        onView(withId(R.id.listButton)).perform(click())
        Thread.sleep(1000)
    }

    @Test
    fun testClickGridAndListButton() {
        onView(withId(R.id.gridButton)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.listButton)).perform(click())
        Thread.sleep(1000)
    }

    @Test
    fun recyclerViewScrollTest() {
        Thread.sleep(1500)
        onView(withId(R.id.homeRecycler)).perform(
            scrollToPosition<PopularListAdapter.MovieHolder>(
                15
            )
        )
        Thread.sleep(1500)
    }
}
