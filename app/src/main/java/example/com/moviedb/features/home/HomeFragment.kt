package example.com.moviedb.features.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
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
        initialLayoutManagers()
    }
    private fun initialUI() {
        MyApp.appComponent.inject(this)
    }
    private fun initialTextWatcher() {
        binding.searchButton.setOnClickListener {
            binding.searchButton.isInvisible = true
            binding.textView.isInvisible = true
            binding.searchMovie.apply {
                isVisible = true
                addTextChangedListener(
                    object : TextWatcher {
                        override fun afterTextChanged(s: Editable?) {
                        }

                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                        }

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                            if (s != null) {
                                if (s.length > 2) {
                                    observeTextWatcherData(s.toString())
                                }
                            }
                            if (s != null) {
                                if (s.length == 0) {
                                    observeData()
                                }
                            }
                        }
                    }
                )
            }
        }
    }
    private fun initialVM() {
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    private fun initialRecyclerView() {
        recyclerAdapter = PopularListAdapter { clickedFav ->
            homeViewModel.checkById(clickedFav, this)
        }
        binding.homeRecycler.apply {
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(true)
            adapter = recyclerAdapter
        }
    }

    private fun observeTextWatcherData(movieName: String) {
        homeViewModel.searchByMovieName(movieName).observe(viewLifecycleOwner) {
            recyclerAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }
    private fun observeData() {
        homeViewModel.getPopularMovieList().observe(viewLifecycleOwner) {
            recyclerAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }
    private fun initialLayoutManagers() {
        binding.gridButton.setOnClickListener {
            binding.gridButton.apply {
                isClickable = false
                setBackgroundColor(R.color.lightGray)
                binding.homeRecycler.apply {
                    layoutManager = GridLayoutManager(this.context, 2)
                }
            }
            binding.listButton.apply {
                isClickable = true
                setBackgroundColor(R.color.white)
            }
        }
        binding.listButton.setOnClickListener {
            binding.gridButton.apply {
                isClickable = true
                setBackgroundColor(R.color.white)
            }
            binding.listButton.apply {
                isClickable = false
                setBackgroundColor(R.color.lightGray)
                binding.homeRecycler.apply {
                    layoutManager = LinearLayoutManager(this.context)
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        binding.searchMovie.setText("")
    }
}
