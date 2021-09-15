package example.com.moviedb.utils

import android.widget.ImageView
import example.com.moviedb.R

fun ImageView.changeFollowingResource(type: Boolean?, imageView: ImageView) {
    if (type == true) {
        imageView.setImageResource(R.drawable.ic_fav_ic)
    } else {
        imageView.setImageResource(R.drawable.ic_unfaw_ic)
    }
}
