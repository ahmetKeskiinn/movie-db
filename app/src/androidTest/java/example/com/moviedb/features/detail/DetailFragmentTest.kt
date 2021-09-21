package example.com.moviedb.features.detail

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import example.com.moviedb.R
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailFragmentTest : TestCase() {
    private lateinit var scenario: FragmentScenario<DetailFragment>
    @Before
    public override fun setUp() {
        super.setUp()
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_AppCompat_DayNight_DarkActionBar)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testClickButton() {
        onView(withId(R.id.insertButton)).perform(click())
        Thread.sleep(1000)
    }
  /*  @Test
    fun testTextView(){
        val testName = "Test"
        val model = Detail()
        model.id = 1
        model.title = testName
        model.overview = testName
        model.posterPath = testName
        model.releaseDate = testName
        model.status = testName
        model.tagline = testName
        model.voteAverage = 2.0
        model.voteCount = 3
        //onView(withId(R.id.idTw)).perform(setTextInTextView("1"))
        onView(withId(R.id.idTw)).perform(replaceText("1"))
        //onView(withId(R.id.genreTw)).perform(replaceText(testName))
    //    onView(withId(R.id.releaseTw)).perform(replaceText(testName))
     //   onView(withId(R.id.overViewTw)).perform(replaceText(testName))
    //    onView(withId(R.id.statusTw)).perform(replaceText(testName))
      //  onView(withId(R.id.taglineTw)).perform(replaceText(testName))
    ///    onView(withId(R.id.voteCountTw)).perform(replaceText(testName))
     //   onView(withId(R.id.voteAverageTw)).perform(replaceText(testName))
        Thread.sleep(1000)
    }*/
}
