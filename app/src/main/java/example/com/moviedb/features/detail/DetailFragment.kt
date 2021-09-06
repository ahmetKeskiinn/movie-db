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
import example.com.moviedb.features.home.HomeViewModel
import example.com.moviedb.utils.ViewModelFactory
import javax.inject.Inject


class DetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var detailViewModel: DetailViewModel

    private lateinit var root:View
    private lateinit var movieId : TextView
    private lateinit var genre: TextView
    private lateinit var releaseDate: TextView
    private lateinit var overView: TextView
    private lateinit var status: TextView
    private lateinit var tagline: TextView
    private lateinit var voteCount: TextView
    private lateinit var voteAverage: TextView
    private lateinit var poster:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_detail, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialUI()
        initialVM()
        arguments?.let {
            observeData(it)
        }

    }
    private fun initialUI(){
        movieId = root.findViewById(R.id.idTw)
        genre = root.findViewById(R.id.genreTw)
        releaseDate = root.findViewById(R.id.releaseTw)
        overView = root.findViewById(R.id.overViewTw)
        status = root.findViewById(R.id.statusTw)
        tagline = root.findViewById(R.id.taglineTw)
        voteCount = root.findViewById(R.id.voteCountTw)
        voteAverage = root.findViewById(R.id.voteAverageTw)
        poster = root.findViewById(R.id.imageView)
    }
    private fun initialVM(){
        MyApp.appComponent.inject(this)
        detailViewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)


    }
    private fun observeData(bundle: Bundle){
        val data = detailViewModel.getMovieDetail(DetailFragmentArgs.fromBundle(bundle).movieId)
        movieId.setText(data.id.toString())
        //genre.setText(data.genres.toString())
        releaseDate.setText(data.releaseDate.toString())
        overView.setText(data.overview.toString())
        status.setText(data.status.toString())
        tagline.setText(data.tagline.toString())
        voteCount.setText(data.voteCount.toString())
        voteAverage.setText(data.voteAverage.toString())
        Log.d("TAG", "observeData: " + data.posterPath.toString())
        updateWithUrl(BuildConfig.IMAGE_BASE_URL+data.posterPath.toString(),poster)

    }
    private fun updateWithUrl(url: String, imageViewAvatar: ImageView) {
        if (!url.isEmpty()) {
            Picasso.get().load(url).into(imageViewAvatar)
        } else {
            Picasso.get().load(R.drawable.ic_launcher_background).centerCrop().resize(200, 200).into(imageViewAvatar)
        }
    }
}