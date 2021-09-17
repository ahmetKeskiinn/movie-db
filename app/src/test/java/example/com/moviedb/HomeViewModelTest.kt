package example.com.moviedb

import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.home.HomeViewModel
import example.com.moviedb.features.home.PopularMovieListSource
import example.com.moviedb.features.home.model.ResultInfo
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class HomeViewModelTest {

    @Mock
    private lateinit var repo: FavRepository

    @Mock
    private lateinit var source: PopularMovieListSource

    @InjectMocks
    private lateinit var viewmodel: HomeViewModel

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
    }
    @Test
    fun testDeleteMovie() {
        val model = ResultInfo(1, "Test")
        viewmodel.deleteMovie(model)
        verify(repo).deleteMovie(model)
    }
    @Test
    fun testInsertMovie() {
        val model = ResultInfo(1, "Test")
        viewmodel.insertMovie(model)
        verify(repo).insertMovie(model)
    }
    @Test
    fun testCheckById() {
        val model = ResultInfo(1, "tesModel", "test")
        // viewmodel.checkById(model)
        //   verify(viewmodel).checkById(model)
    }
    @Test
    fun testGetPopularMovieList() {
        viewmodel.getPopularMovieList()
        verify(source).getPopularMovieList()
    }
    @Test
    fun testGetDbList() {
        viewmodel.getDbList()
        verify(repo).getAllList()
    }
}
