package example.com.moviedb

import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.fav.model.FavModel
import example.com.moviedb.features.home.HomeViewModel
import example.com.moviedb.features.home.PopularMovieListSource
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations





class HomeViewModelTest {
   @Mock
    var source: PopularMovieListSource? = null
    @Mock
    var repo: FavRepository? = null

    @InjectMocks
    var viewmodel: HomeViewModel? = null
    @Test
    fun testDeleteMovie() {
        val model = FavModel("1", "Test")
        viewmodel?.deleteMovie(model)
    }
    @Test
    fun testSearchByMovieName() {
        viewmodel?.searchByMovieName("test")
    }
    @Test
    fun testGetAllList() {
        viewmodel?.getAllList()
    }
    @Test
    fun testCheckById() {
        viewmodel?.checkById("model")
    }

    @Test
    fun testGetPopularMovieList() {
        viewmodel?.getAllList()
    }

}