package example.com.moviedb.features.fav

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import example.com.moviedb.MyApp
import example.com.moviedb.databinding.FragmentDashboardBinding
import example.com.moviedb.features.fav.model.FavModel
import example.com.moviedb.utils.FavMovieViewModelFactory
import javax.inject.Inject
import kotlin.math.log

class FavFragment : Fragment() {

    private lateinit var favViewModel: FavViewModel
    private lateinit var binding:FragmentDashboardBinding
    @Inject
    lateinit var favViewModelFactory: FavMovieViewModelFactory
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialVM()
    }
    private fun initialVM(){
        MyApp.roomComponent.inject(this)
        favViewModel = ViewModelProviders.of(this, favViewModelFactory)[FavViewModel::class.java]
        initialRecyclerView()
    }
    private fun initialRecyclerView(){
        favViewModel.insertMovie(FavModel("1","adas"))
        binding.favRecycler.apply {

        }
        observeData()
    }
    private fun observeData(){
        favViewModel.getAllList().observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "observeData: " + it.size)
            Log.d("TAG", "observeData: " + it.get(0).movieId)
        })
    }
}