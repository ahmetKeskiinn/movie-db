package example.com.moviedb.utils.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.com.moviedb.BuildConfig
import example.com.moviedb.R
import example.com.moviedb.databinding.HomeRecyclerItemBinding
import example.com.moviedb.features.home.HomeFragmentDirections
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.utils.ClickListener
import example.com.moviedb.utils.changeFollowingResource
import example.com.moviedb.utils.updateWithUrl

class PopularListAdapter(
    private val listener: ClickListener,
    private val layoutManager: RecyclerView.LayoutManager
) :
    PagingDataAdapter<ResultInfo, PopularListAdapter.MovieHolder>(
        diffCallback
    ) {
    lateinit var dbList: List<Int?>
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
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.view.movieModel = getItem(position)
        holder.imageMovie.updateWithUrl(BuildConfig.IMAGE_BASE_URL+holder.view.movieModel?.posterPath, holder.imageMovie)
        checkFollow1(holder.followMovie, getItem(position)?.movieNumb)
    }
    private fun checkFollow1(followMovie: ImageView, selectedMdel: Int?) {
        if (dbList.contains(selectedMdel)) {
            followMovie.changeFollowingResource(true, followMovie)
        } else {
            followMovie.changeFollowingResource(false, followMovie)
        }
    }
    private fun checkFollow(followMovie: ImageView, selectedMdel: ResultInfo?) {
        if (selectedMdel?.isFav == true) {
            selectedMdel.isFav = false
            followMovie.changeFollowingResource(selectedMdel.isFav, followMovie)
        } else {
            selectedMdel?.isFav = true
            followMovie.changeFollowingResource(selectedMdel?.isFav, followMovie)
        }
    }
    fun dbLists(modelList: List<Int?>) {
        this.dbList = modelList
    }
    inner class MovieHolder(var view: HomeRecyclerItemBinding) :
        RecyclerView.ViewHolder(view.root), View.OnClickListener {
        val followMovie: ImageView = itemView.findViewById(R.id.followUnfollowStar)
        val imageMovie: ImageView = itemView.findViewById(R.id.imageMovie)
        init {

            view.root.findViewById<ImageView>(R.id.followUnfollowStar).setOnClickListener(this)
            view.root.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            if (v == followMovie) {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    getItem(adapterPosition)?.let { it1 ->
                        listener.itemClick(it1)
                    }

                checkFollow(followMovie, getItem(adapterPosition))
            } else {
                val action = getItem(adapterPosition)?.movieNumb?.let { HomeFragmentDirections.actionNavigationHomeToDetailFragment(it) }
                action?.let { Navigation.findNavController(view.root).navigate(it) }
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
