package example.com.moviedb.features.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import example.com.moviedb.MyApp
import example.com.moviedb.R
import example.com.moviedb.features.home.HomeViewModel
import example.com.moviedb.utils.ViewModelFactory
import javax.inject.Inject


class DetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialUI()
        initialVM()
    }
    private fun initialUI(){
       // MyApp.appComponent.inject(this)
    }
    private fun initialVM(){
        detailViewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
     //   detailViewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

    }
}