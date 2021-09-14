package example.com.moviedb.utils.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import example.com.moviedb.R
import example.com.moviedb.databinding.HomeRecyclerItemBinding
import example.com.moviedb.features.home.HomeFragment
import example.com.moviedb.features.home.HomeFragmentDirections
import example.com.moviedb.features.home.HomeViewModel
import example.com.moviedb.features.home.model.ResultInfo
import example.com.moviedb.utils.changeFollowingResource

class PopularListAdapter(private val onItemClickListener: (ResultInfo) -> Unit) :
    PagingDataAdapter<ResultInfo, PopularListAdapter.MovieHolder>(
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

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.view.movieModel = getItem(position)
        checkFollow(holder.followMovie,getItem(position))
        holder.itemView.setOnClickListener{
           with(getItem(position)){
               val action = HomeFragmentDirections.actionNavigationHomeToDetailFragment(this!!.movieNumb!!)
               Navigation.findNavController(it).navigate(action)
           }
        }
    }

    /*private fun checkFollowFromDB(itemName: String, followMovie: ImageView) {
        if(list.contains(itemName)){
            followMovie.changeFollowingResource("followed",followMovie)
        }
        else{
            followMovie.changeFollowingResource("unfollowed",followMovie)
        }
    }*/
    private fun checkFollow(followMovie: ImageView, selectedMdel: ResultInfo?) {
        if(selectedMdel?.isFav == true){
            Log.d("TAG", "checkFollow:true ")
            followMovie.changeFollowingResource(selectedMdel.isFav,followMovie)
        }
        else{
            Log.d("TAG", "checkFollow:false ")
            followMovie.changeFollowingResource(selectedMdel?.isFav,followMovie)
        }
    }
    fun getMovieAt(position: Int) = getItem(position)
    inner class MovieHolder(var view: HomeRecyclerItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        val followMovie: ImageView = itemView.findViewById(R.id.followUnfollowStar)

        init {
            followMovie.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    getItem(adapterPosition)?.let { it1 -> onItemClickListener(it1) }
                    checkFollow(followMovie,getItem(adapterPosition))
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