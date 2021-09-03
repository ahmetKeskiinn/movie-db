package example.com.moviedb.features.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import example.com.moviedb.MyApp
import example.com.moviedb.R
import example.com.moviedb.utils.ViewModelFactory
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var root:View
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
            for (i in 0..it.size) {
                for(t in 0..it.get(i).results!!.size){
                    Log.d("TAG", "initialUI: " + it.get(i).results!!.get(t))
                }
            }
        })
    }
}