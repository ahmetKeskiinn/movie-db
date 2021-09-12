package example.com.moviedb.features.fav

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.moviedb.MyApp
import example.com.moviedb.databinding.FragmentDashboardBinding
import example.com.moviedb.features.fav.model.FavModel
import example.com.moviedb.utils.ViewModelFactory
import example.com.moviedb.utils.adapters.FavMoviesAdapter
import javax.inject.Inject
import kotlin.math.log

class FavFragment : Fragment() {

    private lateinit var favViewModel: FavViewModel
    private lateinit var binding:FragmentDashboardBinding
    private lateinit var recyclerAdapter : FavMoviesAdapter
    @Inject
    lateinit var favViewModelFactory: ViewModelFactory
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
        initialRecyclerView()
        observeData()
    }
    private fun initialVM(){
        MyApp.appComponent.inject(this)
        favViewModel = ViewModelProviders.of(this, favViewModelFactory)[FavViewModel::class.java]
    }
    private fun deleteFromDb(model: FavModel){
        favViewModel.deleteMovie(model)
        observeData()
    }
    private fun initialRecyclerView(){
        recyclerAdapter = FavMoviesAdapter { clickedFav ->
            deleteFromDb(clickedFav)
        }
        binding.favRecycler.apply {
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(true)
            adapter = recyclerAdapter
        }
    }
    private fun observeData(){
        favViewModel.getAllList().observe(viewLifecycleOwner, Observer {
            recyclerAdapter.submitList(it)
        })
    }

}