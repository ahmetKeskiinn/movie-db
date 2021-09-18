package example.com.moviedb

import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.home.HomeViewModel
import example.com.moviedb.features.home.PopularMovieListSource
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class HomeViewModelTest {
    @Mock
    private lateinit var repo: FavRepository

    @Mock
    private lateinit var source: PopularMovieListSource

    @InjectMocks
    private lateinit var viewmodel: HomeViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testDeleteMovie() {
        val model = ResultInfo(1, "Test")
        viewmodel.deleteMovie(model)
        verify(repo, times(0)).deleteMovie(model)
    }

    @Test
    fun testInsertMovie() {
        val model = ResultInfo(1, "Test")
        viewmodel.insertMovie(model)
        verify(repo, times(0)).insertMovie(model)
    }
    @Test
    fun testSearchByMovieName() {
        viewmodel.searchByMovieName("Test")
        verify(source).getSearchList("Test")
    }
    @Test
    fun testGetPopularList() {
        viewmodel.getPopularMovieList()
        verify(source).getPopularMovieList()
    }
}
