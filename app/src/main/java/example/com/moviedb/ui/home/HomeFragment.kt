package example.com.moviedb.ui.home

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.squareup.okhttp.OkHttpClient
import example.com.moviedb.R
import example.com.moviedb.di.Modules
import retrofit2.Retrofit
import javax.inject.Inject

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var root:View
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
      /*  homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)*/
        root = inflater.inflate(R.layout.fragment_home, container, false)
    //    homeViewModel.getProjectData(1)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialUI()
    }
    private fun initialUI(){
        homeViewModel =
                ViewModelProviders.of(this, HomeFactory()).get(HomeViewModel::class.java)
        //homeViewModel.getProjectData(1)
    }
}