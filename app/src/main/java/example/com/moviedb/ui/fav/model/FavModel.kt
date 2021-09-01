package example.com.moviedb.ui.fav.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fav_table")
data class FavModel(
    @PrimaryKey
    val Name: String,
    val Star: String,
    val Issue: String?,
    val owner: String?,
    val URL: String,
)