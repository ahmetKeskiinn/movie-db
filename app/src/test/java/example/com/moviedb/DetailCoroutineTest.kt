package example.com.moviedb

import example.com.moviedb.features.detail.DetailViewModel
import example.com.moviedb.features.detail.MovieDetailSource
import example.com.moviedb.features.fav.db.FavRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailCoroutineTest {
    @Mock
    private lateinit var repo: FavRepository

    @Mock
    private lateinit var source: MovieDetailSource

    @InjectMocks
    private lateinit var viewmodel: DetailViewModel
    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()
    @ExperimentalCoroutinesApi
    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetMovieDetail() = runBlockingTest {
        viewmodel.getMovieDetail(619778)
    }
}
