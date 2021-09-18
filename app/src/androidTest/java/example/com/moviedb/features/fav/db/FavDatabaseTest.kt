package example.com.moviedb.features.fav.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class FavDatabaseTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: FavDatabase
    private lateinit var dao: FavDAO

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FavDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.getFavDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun testAddMovie() = runBlockingTest {
        val model = ResultInfo(1, "1", "1f", "url", true)
        dao.addMovie(model)
        val allShoppingItems = dao.getAllList().getOrAwaitValue()
        assertThat(allShoppingItems).contains(model)
    }
    @Test
    fun testDeleteMovie() = runBlockingTest {
        val model = ResultInfo(1, "1", "1f", "url", true)
        dao.addMovie(model)

        val getAllListAfterAdd = dao.getAllList().getOrAwaitValue()
        assertThat(getAllListAfterAdd).contains(model)
        dao.deleteMovie(model)
        val allList = dao.getAllList().getOrAwaitValue()
        assertThat(allList.size).isEqualTo(0)
    }
}
