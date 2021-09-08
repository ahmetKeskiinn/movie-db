package example.com.moviedb.utils.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import example.com.moviedb.R
import example.com.moviedb.databinding.HomeRecyclerItemBinding
import example.com.moviedb.features.home.HomeFragmentDirections
import example.com.moviedb.features.home.HomeViewModel
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.utils.changeFollowingResource

class PopularListAdapter(private val onItemClickListener: (ResultInfo) -> Unit) :
    ListAdapter<ResultInfo, PopularListAdapter.MovieHolder>(
        diffCallback
    ) {
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
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.view.movieModel = getItem(position)
        holder.itemView.setOnClickListener{
           with(getItem(position)){
               val action = HomeFragmentDirections.actionNavigationHomeToDetailFragment(this.id!!)
               Navigation.findNavController(it).navigate(action)
           }


        }
    }
    /*private fun changeIcon(type:String, imageView: ImageView){
            imageView.changeFollowingResource()
    }*/

    fun getMovieAt(position: Int) = getItem(position)
    inner class MovieHolder(var view: HomeRecyclerItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        val followMovie: ImageView = itemView.findViewById(R.id.followUnfollowStar)

        init {
            followMovie.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    onItemClickListener(getItem(adapterPosition))
                  //  changeIcon(followMovie)
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