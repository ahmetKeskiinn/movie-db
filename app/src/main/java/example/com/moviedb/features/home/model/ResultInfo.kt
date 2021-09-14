package example.com.moviedb.features.home.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultInfo {
        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("overview")
        @Expose
        var overview: String? = null

        @SerializedName("title")
        @Expose
        var title: String? = null

        var isFav:Boolean? = null
}