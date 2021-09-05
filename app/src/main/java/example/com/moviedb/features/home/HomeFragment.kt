package example.com.moviedb.features.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import example.com.moviedb.MyApp
import example.com.moviedb.R
import example.com.moviedb.utils.ViewModelFactory
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var root:View
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialUI()
    }
    private fun initialUI(){
        MyApp.appComponent.inject(this)
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        homeViewModel.getPopularMovies(2).observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "initialUI: " + it.size)
        })
    }
}