package example.com.moviedb.features.fav

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.home.HomeViewModel
import example.com.moviedb.features.home.PopularMovieListSource
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class FavViewModelTest{
    @Mock
    private lateinit var repo: FavRepository

    @InjectMocks
    private lateinit var viewmodel: FavViewModel

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
    }
    @Test
    fun x(){

    }
  /*  @Test
    fun testDeleteMovie()= runBlockingTest{
        val model = ResultInfo(1, "Test")
        viewmodel.insertMovie(model)
        val getAllList = viewmodel.getAllList().getOrAwaitValue()
        assertThat(getAllList).contains(model)
        viewmodel.deleteMovie(model)
        Mockito.verify(repo).deleteMovie(model)
    }*/
}