package example.com.moviedb.features.home

import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.home.model.ResultInfo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class HomeViewModelTest{
    @Mock
    private lateinit var repo: FavRepository

    @Mock
    private lateinit var source: PopularMovieListSource

    @InjectMocks
    private lateinit var viewmodel: HomeViewModel

    @Before
    public fun before() {
        MockitoAnnotations.initMocks(HomeViewModelTest::class)
    }

    @Test
    fun testInsertMovie() {
        val model = ResultInfo(1, "Test")
        viewmodel.insertMovie(model)
        Mockito.verify(repo).insertMovie(model)
    }
}