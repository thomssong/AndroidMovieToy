package pr.thomassong.model

import com.google.gson.annotations.SerializedName


/**
 *  author thomassong
 */
data class TheMovieGenre (
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String
)