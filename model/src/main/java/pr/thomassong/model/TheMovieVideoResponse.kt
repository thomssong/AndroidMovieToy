package pr.thomassong.model

import com.google.gson.annotations.SerializedName


/**
 *  author thomassong
 */
data class TheMovieVideoResponse (
    override val posId: Int = POS_ID_VIDEO,
    @SerializedName("id") val id: Long,
    @SerializedName("results") val results: List<TheMovieVideo>
): TheMovieDetails

data class TheMovieVideo(
    @SerializedName("id") val id: String,
    @SerializedName("iso_639_1") val language: String?,
    @SerializedName("iso_3166_1") val country: String,
    @SerializedName("key") val key: String,
    @SerializedName("name") val name: String,
    @SerializedName("site") val site: String,
    @SerializedName("size") val size: Int,
    @SerializedName("type") val type: String
)