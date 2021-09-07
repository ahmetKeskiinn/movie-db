package example.com.moviedb.features.fav.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fav_table")
data class FavModel(
    @PrimaryKey
    val movieId: String,
    val Name: String,
)