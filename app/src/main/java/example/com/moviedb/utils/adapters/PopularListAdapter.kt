package example.com.moviedb.utils.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import example.com.moviedb.R
import example.com.moviedb.databinding.HomeRecyclerItemBinding
import example.com.moviedb.features.home.model.ResultInfo

class PopularListAdapter(private val onItemClickListener: (ResultInfo) -> Unit) :
    ListAdapter<ResultInfo, PopularListAdapter.MovieHolder>(
        diffCallback
    ) {
    private val list = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<HomeRecyclerItemBinding>(
            inflater,
            R.layout.home_recycler_item,
            parent,
            false
        )
        return MovieHolder(view)
    }

    fun PopularListAdapter() {
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.view.movieModel = getItem(position)
    }

    fun getMovieAt(position: Int) = getItem(position)
    inner class MovieHolder(var view: HomeRecyclerItemBinding) :
        RecyclerView.ViewHolder(view.root) {
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