package example.com.moviedb.features.home.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "fav")
data class ResultInfo(
    @PrimaryKey
    @SerializedName("id")
    var movieNumb: Int? = null,
    var overview: String? = null,
    var title: String? = null,
    var isFav: Boolean? = null,
)
