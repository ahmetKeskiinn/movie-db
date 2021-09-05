package example.com.moviedb.features.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.com.moviedb.MyApp
import example.com.moviedb.R
import example.com.moviedb.utils.ViewModelFactory
import example.com.moviedb.utils.adapters.PopularListAdapter
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var root:View
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: PopularListAdapter
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
        initialVM()
        initialRecyclerView()
        observeData()
    }
    private fun initialUI(){
        MyApp.appComponent.inject(this)
        recyclerView = root.findViewById(R.id.homeRecycler)
    }
    private fun initialVM(){
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

    }
    private fun initialRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.setHasFixedSize(true)
        recyclerAdapter = PopularListAdapter { clickedFav ->
            //checkRepoFromDB(clickedFav)
        }
        recyclerAdapter.PopularListAdapter(this)
        recyclerView.adapter = recyclerAdapter
    }
    private fun observeData(){
        homeViewModel.getPopularMovies(2).observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "initialUI: " + it.size)
            recyclerAdapter.submitList(it)
           // recyclerView.adapter = it
           // recyclerView.adapter = it
        })
    }
}