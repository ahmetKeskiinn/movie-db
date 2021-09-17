package example.com.moviedb

import example.com.moviedb.features.detail.DetailViewModel
import example.com.moviedb.features.detail.MovieDetailSource
import example.com.moviedb.features.fav.db.FavRepository
import example.com.moviedb.features.home.model.ResultInfo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class DetailViewModelTest : TestRule {
    @Mock
    private lateinit var repo: FavRepository

    @Mock
    private lateinit var source: MovieDetailSource

    @InjectMocks
    private lateinit var viewmodel: DetailViewModel

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
    }
    @Test
    fun testInsertMovie() {
        val model = ResultInfo(1, "1", "test", "testPoster", true)
        viewmodel.insertMovie(model)
        verify(repo, Mockito.times(1)).insertMovie(model)
    }
    @Test
    fun testDeleteMovie() {
        val model = ResultInfo(1, "1", "test", "testPoster", true)
        viewmodel.deleteMovie(model)
        verify(repo, Mockito.times(1)).deleteMovie(model)
    }

    override fun apply(base: Statement?, description: Description?): Statement {
        TODO("Not yet implemented")
    }
}
