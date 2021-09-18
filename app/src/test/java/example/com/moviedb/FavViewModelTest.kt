package example.com.moviedb

import example.com.moviedb.features.fav.FavViewModel
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class FavViewModelTest {
    @Mock
    private lateinit var repo: FavRepository

    @InjectMocks
    private lateinit var viewmodel: FavViewModel

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
    }
    @Test
    fun testInsertMovie() {
        val model = ResultInfo(1, "1", "test", "testPoster", true)
        viewmodel.insertMovie(model)
        Mockito.verify(repo).insertMovie(model)
    }
    @Test
    fun testDeleteMovie() {
        val model = ResultInfo(1, "1", "test", "testPoster", true)
        viewmodel.deleteMovie(model)
        Mockito.verify(repo, times(0)).deleteMovie(model)
    }

    @Test
    fun testGetAllList() {
        val model = ResultInfo(1, "1", "test", "testPoster", true)
        viewmodel.insertMovie(model)
        viewmodel.getAllList()
        Mockito.verify(repo).getAllList()
    }
}
