package example.com.moviedb.features.detail

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import example.com.moviedb.BuildConfig
import example.com.moviedb.MyApp
import example.com.moviedb.R
import example.com.moviedb.databinding.ActivityMainBinding
import example.com.moviedb.databinding.FragmentDetailBinding
import example.com.moviedb.features.home.HomeViewModel
import example.com.moviedb.utils.ViewModelFactory
import javax.inject.Inject


class DetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var dataBinding:FragmentDetailBinding
    private lateinit var poster:ImageView
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        dataBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialVM()
        arguments?.let {
            observeData(it)
        }
    }

    private fun initialVM(){
        MyApp.appComponent.inject(this)
        detailViewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
    }
    private fun observeData(bundle: Bundle){
        val data = detailViewModel.getMovieDetail(DetailFragmentArgs.fromBundle(bundle).movieId)
        dataBinding.movie = data
//        updateWithUrl(BuildConfig.IMAGE_BASE_URL+data.posterPath.toString(),poster)
    }
    private fun updateWithUrl(url: String, imageViewAvatar: ImageView) {
        if (!url.isEmpty()) {
            Picasso.get().load(url).into(imageViewAvatar)
        } else {
            Picasso.get().load(R.drawable.ic_launcher_background).centerCrop().resize(200, 200).into(imageViewAvatar)
        }
    }
}