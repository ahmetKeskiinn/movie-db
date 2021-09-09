package example.com.moviedb.features.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.com.moviedb.MyApp
import example.com.moviedb.R
import example.com.moviedb.databinding.FragmentHomeBinding
import example.com.moviedb.utils.ViewModelFactory
import example.com.moviedb.utils.adapters.PopularListAdapter
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerAdapter: PopularListAdapter
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialUI()
        initialVM()
        initialRecyclerView()
        observeData()
        initialTextWatcher()
    }
    private fun initialUI(){
        MyApp.appComponent.inject(this)
    }
    private fun initialTextWatcher(){
        binding.searchButton.setOnClickListener {
            binding.searchButton.isInvisible = true
            binding.textView.isInvisible = true
            binding.searchMovie.apply {
                isVisible = true
                addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {
                    }

                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        if(s?.length!! >3){
                            observeTextWatcherData(s.toString())
                        }
                    }
                })
            }

        }
    }
    private fun initialVM(){
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }
    private fun initialRecyclerView() {
        recyclerAdapter = PopularListAdapter { clickedFav ->

        }

        binding.homeRecycler.apply {
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(true)
            adapter = recyclerAdapter
        }
    }
    private fun observeData(){
        homeViewModel.getPopularMovies(2).observe(viewLifecycleOwner, Observer {
            recyclerAdapter.submitList(it)
        })
    }
    private fun observeTextWatcherData(movieName: String){
        homeViewModel.searchByMovieName(movieName).observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "observeTextWatcherData: " + it.size )
            if(it.size==0) {
                Toast.makeText(this.context, getString(R.string.didntFind), Toast.LENGTH_SHORT).show()
            }
                recyclerAdapter.submitList(it)

        })
    }

    override fun onStop() {
        super.onStop()
        binding.searchMovie.setText("")
    }


}