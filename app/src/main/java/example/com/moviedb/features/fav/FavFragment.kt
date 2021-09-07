package example.com.moviedb.features.fav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import example.com.moviedb.R
import example.com.moviedb.databinding.FragmentDashboardBinding
import example.com.moviedb.databinding.FragmentHomeBinding

class FavFragment : Fragment() {

    private lateinit var favViewModel: FavViewModel
    private lateinit var binding:FragmentDashboardBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDashboardBinding.inflate(inflater, container, false)

        return binding.root
    }
}