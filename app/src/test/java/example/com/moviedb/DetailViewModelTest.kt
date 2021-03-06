package example.com.moviedb

import example.com.moviedb.features.detail.DetailViewModel
import example.com.moviedb.features.detail.MovieDetailSource
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class DetailViewModelTest {
    @Mock
    private lateinit var repo: FavRepository

    @Mock
    private lateinit var source: MovieDetailSource

    @InjectMocks
    private lateinit var viewmodel: DetailViewModel

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
    }
    @Test
    fun testInsertMovie() {
        val model = ResultInfo(1, "1", "test", "testPoster", true)
        viewmodel.insertMovie(model)
        verify(repo).insertMovie(model)
    }
    @Test
    fun testDeleteMovie() {
        val model = ResultInfo(1, "1", "test", "testPoster", true)
        viewmodel.deleteMovie(model)
        verify(repo).deleteMovie(model)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetMovieDetail() = runBlockingTest {
        viewmodel.getMovieDetail(619778)
    }
}
