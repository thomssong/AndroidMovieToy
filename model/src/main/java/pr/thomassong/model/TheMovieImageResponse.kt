package pr.thomassong.model

import com.google.gson.annotations.SerializedName


/**
 *  author thomassong
 */
data class TheMovieImageResponse (
    @SerializedName("id") val id: Long,
    @SerializedName("backdrops") val backdrops: List<TheMovieImage>,
    @SerializedName("posters") val posters: List<TheMovieImage>
): TheMovieDetails {
    override val posId: Int
        get() = POS_ID_IMAGE
}

data class TheMovieImage (
    @SerializedName("aspect_ratio") val ratio: Float,
    @SerializedName("file_path") val filePath: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("vote_cnt") val voteCnt: Int,
    @SerializedName("iso_639_1") val language: String?
)