package example.com.moviedb.utils.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import example.com.moviedb.R
import example.com.moviedb.features.home.model.ResultInfo

class PopularListAdapter (private val onItemClickListener: (ResultInfo) -> Unit) : ListAdapter<ResultInfo, PopularListAdapter.MovieHolder>(
    diffCallback
) {
    private val list = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.home_recycler_item, parent,
            false)
        return MovieHolder(itemView)
    }

    fun PopularListAdapter(fragment: Fragment) {

    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        with(getItem(position)) {
            holder.movieName.text = this.title
        }

    }


    fun getMovieAt(position: Int) = getItem(position)
    inner class MovieHolder(iv: View) : RecyclerView.ViewHolder(iv) {
        val movieName: TextView = itemView.findViewById(R.id.movieName)
        val followMovie: ImageView = itemView.findViewById(R.id.followUnfollowStar)

        init {
            followMovie.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    onItemClickListener(getItem(adapterPosition))
            }
        }
    }
}

private val diffCallback = object : DiffUtil.ItemCallback<ResultInfo>() {
    override fun areItemsTheSame(oldItem: ResultInfo, newItem: ResultInfo): Boolean {
        return oldItem.title.equals(newItem.title)
    }

    override fun areContentsTheSame(
        oldItem: ResultInfo,
        newItem: ResultInfo
    ): Boolean {
        return oldItem.overview?.equals(newItem.overview) == true
    }
}