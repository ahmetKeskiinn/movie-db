package example.com.moviedb.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import example.com.moviedb.R
import example.com.moviedb.databinding.FavRecyclerItemBinding
import example.com.moviedb.features.fav.FavFragmentDirections
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.utils.changeFollowingResource

class FavMoviesAdapter(private val onItemClickListener: (ResultInfo) -> Unit) :
    ListAdapter<ResultInfo, FavMoviesAdapter.FavMovieHolder>(
        diffCallback
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMovieHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<FavRecyclerItemBinding>(
            inflater,
            R.layout.fav_recycler_item,
            parent,
            false
        )
        return FavMovieHolder(view)
    }
    override fun onBindViewHolder(holder: FavMovieHolder, position: Int) {
        holder.view.favModel = getItem(position)
        holder.followMovie.changeFollowingResource(getItem(position).isFav, holder.followMovie)
        holder.itemView.setOnClickListener {
            with(getItem(position)) {
                val movieID = this.movieNumb
                if (movieID != null) {
                    val action = FavFragmentDirections.actionNavigationFavoritesToDetailFragment(movieID)
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }

    inner class FavMovieHolder(var view: FavRecyclerItemBinding) :
        RecyclerView.ViewHolder(view.root) {
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
        return oldItem.title.equals(newItem.title.toString())
    }

    override fun areContentsTheSame(
        oldItem: ResultInfo,
        newItem: ResultInfo
    ): Boolean {
        return oldItem.title.equals(newItem.title) == true
    }
}
