package example.com.moviedb.ui.fav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import example.com.moviedb.R

class FavFragment : Fragment() {

    private lateinit var favViewModel: FavViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        favViewModel =
                ViewModelProvider(this).get(FavViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
      /*  val textView: TextView = root.findViewById(R.id.text_dashboard)
        favViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}