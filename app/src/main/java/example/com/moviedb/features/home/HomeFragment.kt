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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.moviedb.MyApp
import example.com.moviedb.R
import example.com.moviedb.databinding.FragmentHomeBinding
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.utils.ClickListener
import example.com.moviedb.utils.ViewModelFactory
import example.com.moviedb.utils.adapters.PopularListAdapter
import javax.inject.Inject

class HomeFragment : Fragment(), ClickListener {
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
        getDbList()
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
        recyclerAdapter = PopularListAdapter(this, LinearLayoutManager(this.context))
        binding.homeRecycler.apply {
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(true)
            adapter = recyclerAdapter
        }
    }
    private fun getDbList() {
        homeViewModel.getDbList().observe(
            viewLifecycleOwner,
            Observer {
                var listt: ArrayList<Int?> = ArrayList()
                for (i in 0..it.size - 1) {
                    listt.add(it.get(i).movieNumb)
                }
                recyclerAdapter.dbLists(listt)
            }
        )
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
        binding.listButton.setOnClickListener {
            binding.homeRecycler.apply {
                    layoutManager = LinearLayoutManager(this.context)
                }
        }
        binding.gridButton.setOnClickListener {
            binding.homeRecycler.apply {
                    layoutManager = GridLayoutManager(this.context, 2)
                }
        }
    }
    override fun onStop() {
        super.onStop()
        binding.searchMovie.setText("")
    }
    override fun itemClick(data: ResultInfo) {
        homeViewModel.checkById(data, this)
    }
}
