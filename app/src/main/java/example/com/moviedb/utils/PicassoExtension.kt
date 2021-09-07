package example.com.moviedb.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso
import example.com.moviedb.R

fun ImageView.updateWithUrl(url: String, imageViewAvatar: ImageView) {
    if (!url.isEmpty()) {
        Picasso.get().load(url).into(imageViewAvatar)
    } else {
        Picasso.get().load(R.drawable.ic_launcher_background).centerCrop().resize(200, 200).into(imageViewAvatar)
    }
}