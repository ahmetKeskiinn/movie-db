package example.com.moviedb.features.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import example.com.moviedb.BuildConfig
import example.com.moviedb.MyApp
import example.com.moviedb.databinding.FragmentDetailBinding
import example.com.moviedb.features.detail.model.Detail
import example.com.moviedb.utils.ViewModelFactory
import example.com.moviedb.utils.updateWithUrl
import javax.inject.Inject

class DetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var dataBinding: FragmentDetailBinding
    private lateinit var type: String
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.detailScrollView.apply {
            isVerticalScrollBarEnabled = true
            isHorizontalScrollBarEnabled = false
        }
        initialVM()
        arguments?.let {
            observeData(it)
        }
    }

    private fun initialVM() {
        MyApp.appComponent.inject(this)
        detailViewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
    }
    private fun observeData(bundle: Bundle) {
        detailViewModel.getMovieDetail(DetailFragmentArgs.fromBundle(bundle).movieId).observe(
                viewLifecycleOwner,
                Observer {
                    dataBinding.movie = it

                    dataBinding.imageView.updateWithUrl(BuildConfig.IMAGE_BASE_URL + it.posterPath.toString(), dataBinding.imageView)
                    initialClickers(it)
                    checkDB(it)
                }
        )
    }
    private fun checkDB(model: Detail) {
        detailViewModel.checkDB(this, model, dataBinding.insertButton)
    }
    private fun insertDeleteDb(model: Detail, imageview: ImageView) {
        detailViewModel.insertDeleteDB(this, model, imageview)
    }
    private fun initialClickers(resultInfo: Detail) {
        dataBinding.insertButton.setOnClickListener {
            insertDeleteDb(resultInfo, dataBinding.insertButton)
        }
    }
}
