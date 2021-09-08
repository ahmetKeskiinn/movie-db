package example.com.moviedb.utils

import android.widget.ImageView
import example.com.moviedb.R

fun ImageView.changeFollowingResource(type:String, imageView:ImageView){
    if(type.equals("followed")){
        imageView.setImageResource(R.drawable.ic_fav_ic)
    }
    else{
        imageView.setImageResource(R.drawable.ic_unfaw_ic)
    }
}