package example.com.moviedb.features.detail.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpokenLanguage {
    @SerializedName("english_name")
    @Expose
    var englishName: String? = null

    @SerializedName("iso_639_1")
    @Expose
    var ıso6391: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null
}
